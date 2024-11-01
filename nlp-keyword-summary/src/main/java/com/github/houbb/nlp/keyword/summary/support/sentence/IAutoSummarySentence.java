package com.github.houbb.nlp.keyword.summary.support.sentence;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummarySentence </p>
 * <p> create on 2020/3/12 22:07 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IAutoSummarySentence {

    /**
     * 断句
     * @param text 原始文本
     * @return 结果列表
     * @since 0.0.1
     */
    List<String> sentence(final String text);

}
