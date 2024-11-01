package com.github.houbb.nlp.keyword.summary.support.result.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.nlp.keyword.summary.support.result.IAutoSummaryResultHandler;
import com.github.houbb.heaven.annotation.ThreadSafe;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryResultHandler </p>
 * <p> create on 2020/3/12 22:11 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class AutoSummaryResultHandler implements IAutoSummaryResultHandler<List<IAutoSummaryResult>> {

    /**
     * 结果类处理
     *
     * @param resultList 结果
     * @return 处理结果
     * @since 0.0.1
     */
    @Override
    public List<IAutoSummaryResult> handler(final List<IAutoSummaryResult> resultList) {
        return resultList;
    }

}
