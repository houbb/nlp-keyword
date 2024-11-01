package com.github.houbb.nlp.keyword.similarity.api;

/**
 * <p> project: similarity-ISimilarity </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public interface ISimilarity {

    /**
     * 相似度处理
     * @param context 上下文
     * @return 结果
     * @since 0.0.1
     */
    ISimilarityResult similarity(final ISimilarityContext context);

}
