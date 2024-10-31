package com.github.houbb.nlp.keyword.core.api;

import com.github.houbb.nlp.keyword.core.support.data.idf.IKeywordIdfData;
import com.github.houbb.nlp.keyword.core.support.filter.IKeywordFilter;
import com.github.houbb.nlp.keyword.core.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.core.support.topk.IKeywordTopk;
import com.github.houbb.stopword.api.IStopWord;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordContext {

    /**
     * 限制数量
     * @return 限制数量
     * @since 0.0.1
     */
    int limit();

    /**
     * 停止词数据信息
     * @return 停止词数据信息
     * @since 0.0.1
     */
    IStopWord stopWord();

    /**
     * 逆向文档频率数据信息
     * @return 结果
     * @since 0.0.1
     */
    IKeywordIdfData idfData();

    /**
     * 获取指定的前几个元素
     * @return 前几个元素
     * @since 0.0.1
     */
    IKeywordTopk topk();

    /**
     * 过滤类
     * @return 实现
     * @since 0.0.2
     */
    IKeywordFilter filter();

    /**
     * 读取类
     * @return 实现
     * @since 0.0.5
     */
    IKeywordReader reader();

}
