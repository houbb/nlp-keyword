package com.github.houbb.nlp.keyword.summary.api;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummaryResult {

    /**
     * 句子信息
     * @return 句子
     * @since 0.0.2
     */
    String sentence();

    /**
     * 权重
     * @return 权重
     * @since 0.0.2
     */
    double weight();

    // 其他开始，结束信息等。

}
