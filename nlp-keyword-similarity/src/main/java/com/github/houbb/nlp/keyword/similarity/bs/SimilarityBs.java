package com.github.houbb.nlp.keyword.similarity.bs;

import com.github.houbb.nlp.keyword.similarity.api.ISimilarity;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityContext;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;
import com.github.houbb.nlp.keyword.similarity.api.impl.Similarities;
import com.github.houbb.nlp.keyword.similarity.api.impl.SimilarityContext;
import com.github.houbb.nlp.keyword.similarity.constant.SimilarityConst;
import com.github.houbb.nlp.keyword.similarity.support.keyword.ISimilarityKeyword;
import com.github.houbb.nlp.keyword.similarity.support.keyword.impl.SimilarityKeywords;
import com.github.houbb.nlp.keyword.similarity.support.reader.ISimilarityReader;
import com.github.houbb.nlp.keyword.similarity.support.result.ISimilarityResultHandler;

/**
 * <p> project: similarity-SimilarityBs </p>
 * <p> create on 2020/3/14 14:29 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public final class SimilarityBs {

    private SimilarityBs(){}

    /**
     * 源数据读取类
     * @since 0.0.1
     */
    private ISimilarityReader sourceReader;

    /**
     * 目标数据读取类
     * @since 0.0.1
     */
    private ISimilarityReader targetReader;

    /**
     * 相似度实现
     * @since 0.0.1
     */
    private final ISimilarity similarity = Similarities.defaults();

    /**
     * 关键词
     * @since 0.0.1
     */
    private ISimilarityKeyword keyword = SimilarityKeywords.defaults();

    /**
     * 数量限制
     * @since 0.0.1
     */
    private int limit = SimilarityConst.DEFAULT_KEYWORD_LIMIT;

    /**
     * 新建对象
     * @return this
     * @since 0.0.1
     */
    public static SimilarityBs newInstance() {
        return new SimilarityBs();
    }

    public SimilarityBs sourceReader(ISimilarityReader sourceReader) {
        this.sourceReader = sourceReader;
        return this;
    }

    public SimilarityBs targetReader(ISimilarityReader targetReader) {
        this.targetReader = targetReader;
        return this;
    }

    public SimilarityBs keyword(ISimilarityKeyword keyword) {
        this.keyword = keyword;
        return this;
    }

    public SimilarityBs limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * 相似度计算
     * @param handler 处理类
     * @param <R> 泛型
     * @return 结果
     * @since 0.0.1
     */
    public <R> R similarity(final ISimilarityResultHandler<R> handler) {
        final ISimilarityContext context = buildContext();
        ISimilarityResult result = this.similarity.similarity(context);

        return handler.handler(result);
    }

    /**
     * 构建上下文
     * @return 上下文
     * @since 0.0.1
     */
    private ISimilarityContext buildContext() {
        return SimilarityContext.newInstance()
                .sourceReader(sourceReader)
                .targetReader(targetReader)
                .keyword(keyword)
                .limit(limit);
    }

}
