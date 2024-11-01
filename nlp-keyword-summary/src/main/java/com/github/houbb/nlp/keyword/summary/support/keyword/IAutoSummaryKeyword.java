package com.github.houbb.nlp.keyword.summary.support.keyword;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummaryKeyword </p>
 * <p> create on 2020/3/12 22:00 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummaryKeyword {

    /**
     * 获取关键词列表
     * @param text 原始文本
     * @param limit 数量限制
     * @return 结果列表
     * @since 0.0.1
     */
    List<IKeywordResult> keyword(final String text, final int limit);

}
