package com.github.houbb.nlp.keyword.summary.support.keyword.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.util.KeywordHelper;
import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;

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
