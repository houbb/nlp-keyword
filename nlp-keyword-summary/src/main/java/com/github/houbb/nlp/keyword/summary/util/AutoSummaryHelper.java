package com.github.houbb.nlp.keyword.summary.util;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummary;
import com.github.houbb.nlp.keyword.summary.api.impl.AutoSummaries;
import com.github.houbb.nlp.keyword.summary.bs.AutoSummaryBs;
import com.github.houbb.nlp.keyword.summary.constant.AutoSummaryConst;
import com.github.houbb.nlp.keyword.summary.support.reader.impl.AutoSummaryReaders;
import com.github.houbb.nlp.keyword.summary.support.result.impl.AutoSummaryResultHandlers;

/**
 * <p> project: auto-summary-AutoSummaryHelper </p>
 * <p> create on 2020/3/12 22:14 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaryHelper {

    private AutoSummaryHelper(){}


    /**
     * 自动摘要
     * @param text 文本
     * @return 结果
     * @since 0.0.1
     */
    public static String autoSummary(final String text) {
        return autoSummary(text, AutoSummaryConst.DEFAULT_LIMIT);
    }

    /**
     * 自动摘要
     * @param text 文本
     * @param limit 句子数量
     * @return 结果
     * @since 0.0.1
     */
    public static String autoSummary(final String text, final int limit) {
        return autoSummary(text, limit, AutoSummaries.simple());
    }

    /**
     * 自动摘要
     * @param text 文本
     * @param summary 摘要实现
     * @return 结果
     * @since 0.0.2
     */
    public static String autoSummary(final String text, final IAutoSummary summary) {
        return autoSummary(text, AutoSummaryConst.DEFAULT_LIMIT, summary);
    }

    /**
     * 自动摘要
     * @param text 文本
     * @param limit 句子数量
     * @param summary 概要实现
     * @return 结果
     * @since 0.0.2
     */
    public static String autoSummary(final String text, final int limit, final IAutoSummary summary) {
        ArgUtil.notEmpty(text, "text");
        ArgUtil.notNegative(limit, "limit");
        ArgUtil.notNull(summary, "summary");

        return AutoSummaryBs.newInstance()
                .reader(AutoSummaryReaders.string(text))
                .limit(limit)
                .summary(summary)
                .autoSummary(AutoSummaryResultHandlers.string());
    }

}
