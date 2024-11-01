package com.github.houbb.nlp.keyword.similarity.api.impl;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;

/**
 * <p> project: similarity-ISimilarity </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
@NotThreadSafe
public class SimilarityResult implements ISimilarityResult {

    /**
     * 相似度
     * @since 0.0.1
     */
    private double similarity;

    /**
     * 实现对象实例
     * @return 实现
     * @since 0.0.1
     */
    public static SimilarityResult newInstance() {
        return new SimilarityResult();
    }

    @Override
    public double similarity() {
        return similarity;
    }

    public SimilarityResult similarity(double similarity) {
        this.similarity = similarity;
        return this;
    }

}
