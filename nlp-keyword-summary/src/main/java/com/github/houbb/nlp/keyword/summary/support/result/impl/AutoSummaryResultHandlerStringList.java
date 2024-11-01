package com.github.houbb.nlp.keyword.summary.support.result.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.nlp.keyword.summary.support.result.IAutoSummaryResultHandler;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryResultHandler </p>
 * <p> create on 2020/3/12 22:11 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class AutoSummaryResultHandlerStringList implements IAutoSummaryResultHandler<List<String>> {

    @Override
    public List<String> handler(List<IAutoSummaryResult> resultList) {
        return CollectionUtil.toList(resultList, new IHandler<IAutoSummaryResult, String>() {
            @Override
            public String handle(IAutoSummaryResult result) {
                return result.sentence();
            }
        });
    }

}
