package com.github.houbb.nlp.keyword.core.support.filter.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.support.pipeline.impl.DefaultPipeline;
import com.github.houbb.nlp.keyword.core.api.IKeywordContext;
import com.github.houbb.nlp.keyword.core.support.filter.IKeywordFilter;

import java.util.List;

/**
 * 过滤类实现
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public abstract class AbstractKeywordFilter implements IKeywordFilter {

    @Override
    public boolean filter(final String word, final IKeywordContext context) {
        Pipeline<IKeywordFilter> filterPipeline = new DefaultPipeline<>();
        this.init(word, filterPipeline);

        List<IKeywordFilter> filters = filterPipeline.list();
        for(IKeywordFilter filter : filters) {
            if(filter.filter(word, context)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 初始化
     * @param word 单词
     * @param filterPipeline 结果
     * @since 0.0.2
     */
    protected abstract void init(final String word, final Pipeline<IKeywordFilter> filterPipeline);


}
