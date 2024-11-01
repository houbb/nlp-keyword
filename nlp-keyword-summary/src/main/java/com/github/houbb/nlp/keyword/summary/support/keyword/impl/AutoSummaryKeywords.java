package com.github.houbb.nlp.keyword.summary.support.keyword.impl;

import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;
import com.github.houbb.heaven.support.instance.impl.Instances;

/**
 * <p> project: auto-summary-IAutoSummaryKeyword </p>
 * <p> create on 2020/3/12 22:00 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaryKeywords {

    private AutoSummaryKeywords(){}

    /**
     * 默认实现
     * @since 0.0.1
     * @return 关键字
     */
    public static IAutoSummaryKeyword defaults() {
        return Instances.singleton(AutoSummaryKeyword.class);
    }

}
