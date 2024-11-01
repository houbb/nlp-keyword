package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;
import com.github.houbb.nlp.keyword.summary.support.reader.IAutoSummaryReader;
import com.github.houbb.nlp.keyword.summary.support.sentence.IAutoSummarySentence;
import com.github.houbb.heaven.annotation.NotThreadSafe;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public class AutoSummaryContext implements IAutoSummaryContext {

    /**
     * 关键字实现
     * @since 0.0.1
     */
    private IAutoSummaryKeyword keyword;

    /**
     * 断句实现
     * @since 0.0.1
     */
    private IAutoSummarySentence sentence;

    /**
     * 文本的读取实现类
     * @since 0.0.1
     */
    private IAutoSummaryReader reader;

    /**
     * 限制句子数量
     * @return 数量
     * @since 0.0.1
     */
    private int limit;

    /**
     * 新建对象实例
     * @return this
     * @since 0.0.1
     */
    public static AutoSummaryContext newInstance() {
        return new AutoSummaryContext();
    }

    @Override
    public IAutoSummaryKeyword keyword() {
        return keyword;
    }

    public AutoSummaryContext keyword(IAutoSummaryKeyword keyword) {
        this.keyword = keyword;
        return this;
    }

    @Override
    public IAutoSummarySentence sentence() {
        return sentence;
    }

    public AutoSummaryContext sentence(IAutoSummarySentence sentence) {
        this.sentence = sentence;
        return this;
    }

    @Override
    public IAutoSummaryReader reader() {
        return reader;
    }

    public AutoSummaryContext reader(IAutoSummaryReader reader) {
        this.reader = reader;
        return this;
    }

    @Override
    public int limit() {
        return limit;
    }

    public AutoSummaryContext limit(int limit) {
        this.limit = limit;
        return this;
    }
}
