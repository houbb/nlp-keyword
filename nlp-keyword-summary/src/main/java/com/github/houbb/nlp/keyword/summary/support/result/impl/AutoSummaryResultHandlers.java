package com.github.houbb.nlp.keyword.summary.support.result.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.nlp.keyword.summary.support.result.IAutoSummaryResultHandler;
import com.github.houbb.heaven.support.instance.impl.Instances;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryResultHandler </p>
 * <p> create on 2020/3/12 22:11 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaryResultHandlers {

    private AutoSummaryResultHandlers(){}

    /**
     * 默认实现
     * @since 0.0.2
     * @return 默认
     */
    public static IAutoSummaryResultHandler<List<IAutoSummaryResult>> defaults() {
        return Instances.singleton(AutoSummaryResultHandler.class);
    }

    /**
     * 字符串实现
     * @since 0.0.2
     * @return 默认
     */
    public static IAutoSummaryResultHandler<String> string() {
        return Instances.singleton(AutoSummaryResultHandlerString.class);
    }

    /**
     * 字符串列表实现
     * @since 0.0.2
     * @return 默认
     */
    public static IAutoSummaryResultHandler<List<String>> stringList() {
        return Instances.singleton(AutoSummaryResultHandlerStringList.class);
    }

}
