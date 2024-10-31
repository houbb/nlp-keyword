package com.github.houbb.nlp.keyword.core.support.segment;

import java.util.List;

/**
 * 关键词分词
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordSegment {

    /**
     * 分词
     * @param text 文本
     * @return 结果
     * @since 0.0.1
     */
    List<String> segment(final String text);

}
