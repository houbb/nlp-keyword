package com.github.houbb.nlp.keyword.core.support.filter.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.nlp.keyword.api.core.IKeywordContext;
import com.github.houbb.nlp.keyword.api.support.filter.IKeywordFilter;

/**
 * 过滤类实现
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public class EmptyKeywordFilter implements IKeywordFilter {

    @Override
    public boolean filter(final String word, final IKeywordContext context) {
        return StringUtil.isEmptyTrim(word);
    }


}
