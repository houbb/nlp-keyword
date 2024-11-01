package com.github.houbb.nlp.keyword.summary.api;

import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;
import com.github.houbb.nlp.keyword.summary.support.reader.IAutoSummaryReader;
import com.github.houbb.nlp.keyword.summary.support.sentence.IAutoSummarySentence;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummaryContext {

    /**
     * 关键字实现
     * @return 关键字实现
     * @since 0.0.1
     */
    IAutoSummaryKeyword keyword();

    /**
     * 断句实现
     * @return 实现
     * @since 0.0.1
     */
    IAutoSummarySentence sentence();

    /**
     * 文本的读取实现类
     * @return 实现
     * @since 0.0.1
     */
    IAutoSummaryReader reader();

    /**
     * 限制句子数量
     * @return 数量
     * @since 0.0.1
     */
    int limit();

}
