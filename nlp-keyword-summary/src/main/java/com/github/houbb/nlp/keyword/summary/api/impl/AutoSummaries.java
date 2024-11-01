package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummary;
import com.github.houbb.heaven.support.instance.impl.Instances;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaries {

    private AutoSummaries(){}

    /**
     * 默认实现
     * @return 实现
     * @since 0.0.1
     */
    public static IAutoSummary simple() {
        return Instances.singleton(AutoSummarySimple.class);
    }

    /**
     * 考虑到关键词的权重
     * @return 实现
     * @since 0.0.2
     */
    public static IAutoSummary weight() {
        return Instances.singleton(AutoSummaryWeight.class);
    }

}
