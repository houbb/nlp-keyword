package com.github.houbb.nlp.keyword.similarity.support.keyword;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;

import java.util.List;
import java.util.Map;

/**
 * <p> project: auto-summary-IAutoSummaryKeyword </p>
 * <p> create on 2020/3/12 22:00 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface ISimilarityKeyword {

    /**
     * 获取关键词列表
     * @param text 原始文本
     * @param limit 数量限制
     * @return 结果列表
     * @since 0.0.1
     */
    List<IKeywordResult> keywordList(final String text, final int limit);

    /**
     * map 信息
     * @param text 原始文本
     * @param limit 限制数量
     * @return 结果
     * @since 0.0.1
     */
    Map<String, Double> keywordMap(final String text, final int limit);

}
