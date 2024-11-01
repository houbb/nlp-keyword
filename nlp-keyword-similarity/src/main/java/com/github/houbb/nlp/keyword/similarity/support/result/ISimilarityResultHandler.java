package com.github.houbb.nlp.keyword.similarity.support.result;

import com.github.houbb.nlp.keyword.similarity.api.ISimilarityResult;

/**
 * <p> project: similarity-ISimilarityResultHandler </p>
 * <p> create on 2020/3/14 10:48 </p>
 *
 * @author Administrator
 * @since 1.0.0
 * @param <R> 泛型
 */
public interface ISimilarityResultHandler<R> {

    /**
     * 结果处理
     * @param result 结果
     * @return 处理结果
     * @since 0.0.1
     */
    R handler(final ISimilarityResult result);

}
