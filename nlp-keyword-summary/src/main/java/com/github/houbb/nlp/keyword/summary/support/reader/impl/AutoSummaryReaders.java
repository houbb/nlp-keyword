package com.github.houbb.nlp.keyword.summary.support.reader.impl;

import com.github.houbb.nlp.keyword.summary.support.reader.IAutoSummaryReader;

/**
 * <p> project: auto-summary-IAutoSummaryReader </p>
 * <p> create on 2020/3/12 22:16 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaryReaders {

    private AutoSummaryReaders(){}

    /**
     * 字符串实现
     * @param string 字符串
     * @return 结果
     * @since 0.0.1
     */
    public static IAutoSummaryReader string(final String string) {
        return new AutoSummaryReaderString(string);
    }

}
