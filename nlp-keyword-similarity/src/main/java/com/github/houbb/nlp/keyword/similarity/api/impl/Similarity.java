package com.github.houbb.nlp.keyword.similarity.api.impl;

import com.github.houbb.heaven.annotation.CommonEager;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.MapUtil;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarity;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityContext;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;

import java.util.List;
import java.util.Map;

/**
 * （1）使用TF-IDF算法，找出两篇文章的关键词；
 *
 * （2）每篇文章各取出若干个关键词（比如20个），合并成一个集合，计算每篇文章对于这个集合中的词的词频（为了避免文章长度的差异，可以使用相对词频）；
 *
 * （3）生成两篇文章各自的词频向量；
 *
 * （4）计算两个向量的余弦相似度，值越大就表示越相似。
 *
 * <p> project: similarity-ISimilarity </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
@ThreadSafe
public class Similarity implements ISimilarity {

    /**
     * 相似度处理
     *
     * @param context 上下文
     * @return 结果
     * @since 0.0.1
     */
    @Override
    public ISimilarityResult similarity(final ISimilarityContext context) {
        final String sourceText = context.sourceReader().reader();
        final String targetText = context.targetReader().reader();

        //2.1 源库 keywords
        final Map<String, Double> sourceKeywordMap = context.keyword().keywordMap(sourceText, Integer.MAX_VALUE);
        //2.2 目标 keywords
        final Map<String, Double> targetKeywordMap = context.keyword().keywordMap(targetText, Integer.MAX_VALUE);

        //3. 列出所有的词，构建对应的词向量
        List<String> allWordList = CollectionUtil.union(sourceKeywordMap.keySet(), targetKeywordMap.keySet());
        //3.1 对需要计算的向量尽量截断，避免过大的计算量？
        //TODO: 这里有一个问题，如果直接截断，选取的关键词是否有代表性？如何提升代表性？
        allWordList = CollectionUtil.subList(allWordList, 0, context.limit());

        //3.1 构建词向量
        List<Double> sourceVector = CollectionUtil.toList(allWordList, new IHandler<String, Double>() {
            @Override
            public Double handle(String s) {
                return MapUtil.getMapValue(sourceKeywordMap, s, 0.0);
            }
        });
        List<Double> targetVector = CollectionUtil.toList(allWordList, new IHandler<String, Double>() {
            @Override
            public Double handle(String s) {
                return MapUtil.getMapValue(targetKeywordMap, s, 0.0);
            }
        });

        //4. 计算余弦相似度+
        double cosineSimilarity = cosineSimilarity(sourceVector, targetVector);

        //5. 构建结果
        return SimilarityResult.newInstance().similarity(cosineSimilarity);
    }

    /**
     * 计算余弦相似度
     *
     * 应该抽象到数学库中。
     *
     * <pre>
     * x1*y1 + x2*y2 + ... xn*yn
     * ----------------------------------------------------
     * sqrt(x1^2+x2^2+...+xn^2) * sqrt(y1^2+y2^2+...+yn^2)
     * </pre>
     * @param sourceList 源
     * @param targetList 目标
     * @return 结果
     * @since 0.0.1
     */
    @CommonEager
    private double cosineSimilarity(final List<Double> sourceList, final List<Double> targetList) {
        double fenzi = 0.0;
        double sourceSquare = 0.0;
        double targetSquare = 0.0;

        for(int i = 0; i < sourceList.size(); i++) {
            // 计算分子
            fenzi += sourceList.get(i) * targetList.get(i);

            // 计算平方和
            sourceSquare += sourceList.get(i) * sourceList.get(i);
            targetSquare += targetList.get(i) * targetList.get(i);
        }

        double fenmu = Math.sqrt(sourceSquare) * Math.sqrt(targetSquare);
        if(fenmu == 0) {
            return 0;
        }
        return fenzi / fenmu;
    }

}
