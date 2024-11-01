package com.github.houbb.nlp.keyword.similarity.support.reader.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.similarity.support.reader.ISimilarityReader;

/**
 * <p> project: auto-summary-IAutoSummaryReader </p>
 * <p> create on 2020/3/12 22:16 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class SimilarityReaderString implements ISimilarityReader {

    /**
     * 文本信息
     * @since 0.0.1
     */
    private final String string;

    public SimilarityReaderString(String string) {
        this.string = string;
    }

    /**
     * 读取
     * @return 字符串
     * @since 0.0.1
     */
    @Override
    public String reader() {
        return string;
    }

}
