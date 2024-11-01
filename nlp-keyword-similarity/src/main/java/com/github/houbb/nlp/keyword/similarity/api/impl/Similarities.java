package com.github.houbb.nlp.keyword.similarity.api.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarity;

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
public final class Similarities {

    private Similarities(){}


    /**
     * 默认实现
     * @return 实现
     * @since 0.0.1
     */
    public static ISimilarity defaults() {
        return Instances.singleton(Similarity.class);
    }

}
