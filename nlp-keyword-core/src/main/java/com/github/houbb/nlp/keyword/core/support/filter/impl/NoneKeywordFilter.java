package com.github.houbb.nlp.keyword.core.support.filter.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.core.api.IKeywordContext;
import com.github.houbb.nlp.keyword.core.support.filter.IKeywordFilter;

/**
 * 过滤类实现
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public class NoneKeywordFilter implements IKeywordFilter {

    @Override
    public boolean filter(final String word, final IKeywordContext context) {
        return false;
    }

}
