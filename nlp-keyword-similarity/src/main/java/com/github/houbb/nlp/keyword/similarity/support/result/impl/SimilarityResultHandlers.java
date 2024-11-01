package com.github.houbb.nlp.keyword.similarity.support.result.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;
import com.github.houbb.nlp.keyword.similarity.support.result.ISimilarityResultHandler;

/**
 * <p> project: similarity-ISimilarityResultHandler </p>
 * <p> create on 2020/3/14 10:48 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public final class SimilarityResultHandlers {

    private SimilarityResultHandlers(){}

    /**
     * 相似度
     * @return 相似度
     * @since 0.0.1
     */
    public static ISimilarityResultHandler<Double> doubles() {
        return Instances.singleton(SimilarityResultHandlerDouble.class);
    }

    /**
     * 相似度
     * @return 相似度
     * @since 0.0.1
     */
    public static ISimilarityResultHandler<ISimilarityResult> defaults() {
        return Instances.singleton(SimilarityResultHandler.class);
    }

}
