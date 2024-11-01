package com.github.houbb.nlp.keyword.similarity.api;

import com.github.houbb.nlp.keyword.similarity.support.keyword.ISimilarityKeyword;
import com.github.houbb.nlp.keyword.similarity.support.reader.ISimilarityReader;

/**
 * <p> project: similarity-ISimilarity </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public interface ISimilarityContext {

    /**
     * 源数据读取类
     * @return 读取类
     * @since 0.0.1
     */
    ISimilarityReader sourceReader();

    /**
     * 目标数据读取类
     * @return 读取类
     * @since 0.0.1
     */
    ISimilarityReader targetReader();

    /**
     * 关键词
     * @return 关键词实现
     * @since 0.0.1
     */
    ISimilarityKeyword keyword();

    /**
     * 数量限制
     * @return 数量限制
     * @since 0.0.1
     */
    int limit();

}
