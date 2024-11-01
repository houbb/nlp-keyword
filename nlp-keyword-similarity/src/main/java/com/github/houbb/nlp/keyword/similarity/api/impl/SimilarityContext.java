package com.github.houbb.nlp.keyword.similarity.api.impl;

import com.github.houbb.nlp.keyword.similarity.api.ISimilarityContext;
import com.github.houbb.nlp.keyword.similarity.support.keyword.ISimilarityKeyword;
import com.github.houbb.nlp.keyword.similarity.support.reader.ISimilarityReader;

/**
 * <p> project: similarity-ISimilarity </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public class SimilarityContext implements ISimilarityContext {

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
     * 数量限制
     * @since 0.0.1
     */
    private int limit;

    /**
     * 关键词
     * @since 0.0.1
     */
    private ISimilarityKeyword keyword;

    /**
     * 新建实例
     * @since 0.0.1
     * @return this
     */
    public static SimilarityContext newInstance() {
        return new SimilarityContext();
    }

    @Override
    public ISimilarityReader sourceReader() {
        return sourceReader;
    }

    public SimilarityContext sourceReader(ISimilarityReader sourceReader) {
        this.sourceReader = sourceReader;
        return this;
    }

    @Override
    public ISimilarityReader targetReader() {
        return targetReader;
    }

    public SimilarityContext targetReader(ISimilarityReader targetReader) {
        this.targetReader = targetReader;
        return this;
    }

    @Override
    public int limit() {
        return limit;
    }

    public SimilarityContext limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public ISimilarityKeyword keyword() {
        return keyword;
    }

    public SimilarityContext keyword(ISimilarityKeyword keyword) {
        this.keyword = keyword;
        return this;
    }
}
