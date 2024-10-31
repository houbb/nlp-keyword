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
public class StopWordKeywordFilter implements IKeywordFilter {

    /**
     * 对单词信息进行过滤
     *
     * @param word 单词
     * @return 是否过滤
     * @since 0.0.2
     */
    @Override
    public boolean filter(final String word, final IKeywordContext context) {
        return context.stopWord().contains(word);
    }

}
