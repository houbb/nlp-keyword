package com.github.houbb.nlp.keyword.summary.api;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummary {

    /**
     * 自动摘要
     * @param context 上下文
     * @return 结果
     * @since 0.0.1
     */
    List<IAutoSummaryResult> autoSummary(final IAutoSummaryContext context);

}
