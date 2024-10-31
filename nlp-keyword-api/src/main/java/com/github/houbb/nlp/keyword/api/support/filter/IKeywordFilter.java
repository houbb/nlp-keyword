package com.github.houbb.nlp.keyword.api.support.filter;


import com.github.houbb.nlp.keyword.api.core.IKeywordContext;

/**
 * 过滤类接口
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordFilter {

    /**
     * 对单词信息进行过滤
     *
     * @param word 单词
     * @param context 上下文
     * @return 是否过滤
     * @since 0.0.1
     */
    boolean filter(final String word, final IKeywordContext context);


}
