package com.github.houbb.nlp.keyword.summary.support.result;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryResultHandler </p>
 * <p> create on 2020/3/12 22:11 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummaryResultHandler<R> {

    /**
     * 结果类处理
     * @param resultList 结果
     * @return 处理结果
     * @since 0.0.1
     */
    R handler(final List<IAutoSummaryResult> resultList);

}
