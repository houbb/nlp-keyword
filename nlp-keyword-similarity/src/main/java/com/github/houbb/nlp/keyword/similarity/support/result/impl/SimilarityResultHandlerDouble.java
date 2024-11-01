package com.github.houbb.nlp.keyword.similarity.support.result.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;
import com.github.houbb.nlp.keyword.similarity.support.result.ISimilarityResultHandler;

/**
 * <p> project: similarity-ISimilarityResultHandler </p>
 * <p> create on 2020/3/14 10:48 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
@ThreadSafe
public class SimilarityResultHandlerDouble implements ISimilarityResultHandler<Double> {

    /**
     * 结果处理
     * @param result 结果
     * @return 处理结果
     * @since 0.0.1
     */
    @Override
    public Double handler(final ISimilarityResult result) {
        return result.similarity();
    }

}
