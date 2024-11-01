package com.github.houbb.nlp.keyword.summary.support.result.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.nlp.keyword.summary.support.result.IAutoSummaryResultHandler;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryResultHandler </p>
 * <p> create on 2020/3/12 22:11 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class AutoSummaryResultHandlerString implements IAutoSummaryResultHandler<String> {

    @Override
    public String handler(List<IAutoSummaryResult> resultList) {
        final List<String> stringList = AutoSummaryResultHandlers.stringList().handler(resultList);
        return StringUtil.join(stringList, StringUtil.EMPTY);
    }

}
