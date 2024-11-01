package com.github.houbb.nlp.keyword.similarity.support.reader.impl;


import com.github.houbb.nlp.keyword.similarity.support.reader.ISimilarityReader;

/**
 * <p> project: auto-summary-ISimilarityReader </p>
 * <p> create on 2020/3/12 22:16 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class SimilarityReaders {

    private SimilarityReaders(){}

    /**
     * 字符串实现
     * @param string 字符串
     * @return 结果
     * @since 0.0.1
     */
    public static ISimilarityReader string(final String string) {
        return new SimilarityReaderString(string);
    }

}
