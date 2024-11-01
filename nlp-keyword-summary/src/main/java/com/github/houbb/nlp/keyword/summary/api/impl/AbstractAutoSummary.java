package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummary;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.heaven.annotation.ThreadSafe;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public abstract class AbstractAutoSummary implements IAutoSummary {

    /**
     * 获取摘要列表
     * @param sentenceList 句子列表
     * @param keywordResults 关键词信息
     * @param context 上下文
     * @return 结果列表
     * @since 0.0.2
     */
    protected abstract List<IAutoSummaryResult> getSummaryList(final List<String> sentenceList,
                                          final List<IKeywordResult> keywordResults,
                                          final IAutoSummaryContext context);

    /**
     * 自动摘要
     *
     * @param context 上下文
     * @return 结果
     * @since 0.0.1
     */
    @Override
    public List<IAutoSummaryResult> autoSummary(final IAutoSummaryContext context) {
        //1. 文本
        final String text = getText(context);

        //2. 句子
        List<String> sentenceList = getSentenceList(text, context);

        //3. 关键字
        List<IKeywordResult> keywordList = getKeywordResults(text, context);

        //4. 构建 summary 列表
        List<IAutoSummaryResult> summaryList  = getSummaryList(sentenceList, keywordList, context);

        //5. 返回结果对象
        return summaryList;
    }


    /**
     * 获取文本信息
     * @param context 上下文
     * @return 字符串
     * @since 0.0.2
     */
    protected String getText(final IAutoSummaryContext context) {
        return context.reader().reader();
    }

    /**
     * 获取断句信息
     * @param text 文本
     * @param context 上下文
     * @return 句子列表
     * @since 0.0.2
     */
    protected List<String> getSentenceList(final String text,
                                           final IAutoSummaryContext context) {
        return context.sentence().sentence(text);
    }

    /**
     * 获取关键词信息
     *
     * map(string, integer) 关键词，权重
     * @param text 文本
     * @param context 上下文
     * @return 句子列表
     * @since 0.0.2
     */
    protected List<IKeywordResult> getKeywordResults(final String text,
                                                     final IAutoSummaryContext context) {
        final int limit = context.limit();
        final int keywordLimit = limit * 3;
        return context.keyword().keyword(text, keywordLimit);
    }


}
