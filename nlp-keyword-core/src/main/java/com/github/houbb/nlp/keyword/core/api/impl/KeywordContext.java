package com.github.houbb.nlp.keyword.core.api.impl;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.nlp.keyword.core.api.IKeywordContext;
import com.github.houbb.nlp.keyword.core.support.data.idf.IKeywordIdfData;
import com.github.houbb.nlp.keyword.core.support.filter.IKeywordFilter;
import com.github.houbb.nlp.keyword.core.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.core.support.topk.IKeywordTopk;
import com.github.houbb.stopword.api.IStopWord;


/**
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public class KeywordContext implements IKeywordContext {

    /**
     * 限制数量
     * @since 0.0.1
     */
    private int limit;

    /**
     * 逆文档数据
     * @since 0.0.1
     */
    private IKeywordIdfData idfData;

    /**
     * 停止词数据
     * @since 0.0.1
     */
    private IStopWord stopWord;

    /**
     * 前几个元素
     * @since 0.0.1
     */
    private IKeywordTopk topk;

    /**
     * 过滤类
     * @since 0.0.2
     */
    private IKeywordFilter filter;

    /**
     * 读取类
     * @since 0.0.5
     */
    private IKeywordReader reader;

    /**
     * 新建对象实例
     * @return 对象实例
     * @since 0.0.1
     */
    public static KeywordContext newInstance() {
        return new KeywordContext();
    }

    public KeywordContext limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public int limit() {
        return this.limit;
    }

    @Override
    public IKeywordIdfData idfData() {
        return idfData;
    }

    public KeywordContext idfData(IKeywordIdfData idfData) {
        this.idfData = idfData;
        return this;
    }

    @Override
    public IStopWord stopWord() {
        return stopWord;
    }

    public KeywordContext stopWord(IStopWord stopWord) {
        this.stopWord = this.stopWord;
        return this;
    }

    @Override
    public IKeywordTopk topk() {
        return topk;
    }

    public KeywordContext topk(IKeywordTopk topk) {
        this.topk = topk;
        return this;
    }

    @Override
    public IKeywordFilter filter() {
        return filter;
    }

    public KeywordContext filter(IKeywordFilter filter) {
        this.filter = filter;
        return this;
    }

    @Override
    public IKeywordReader reader() {
        return reader;
    }

    public KeywordContext reader(IKeywordReader reader) {
        this.reader = reader;
        return this;
    }
}
