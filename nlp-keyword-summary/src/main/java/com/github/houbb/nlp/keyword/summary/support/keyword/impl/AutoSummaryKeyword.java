package com.github.houbb.nlp.keyword.summary.support.keyword.impl;

import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.keyword.api.IKeywordResult;
import com.github.houbb.keyword.util.KeywordHelper;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryKeyword </p>
 * <p> create on 2020/3/12 22:00 </p>
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public class AutoSummaryKeyword implements IAutoSummaryKeyword {

    @Override
    public List<IKeywordResult> keyword(String text, int limit) {
        return KeywordHelper.keyword(text, limit);
    }

}
