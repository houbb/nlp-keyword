package com.github.houbb.nlp.keyword.core.support.reader.impl;

import com.github.houbb.nlp.keyword.api.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.api.support.segment.IKeywordSegment;

import java.util.Map;

/**
 * <p> project: keyword-IKeywordReader </p>
 * <p> create on 2020/3/19 22:46 </p>
 *
 * @author binbin.hou
 * @since 0.0.5
 */
public final class KeywordReaders {

    private KeywordReaders(){}

    /**
     * 默认实现
     * @param countMap 结果
     * @return 实现
     * @since 0.0.5
     */
    public static IKeywordReader wordCount(final Map<String, Integer> countMap) {
        return new KeywordReader(countMap);
    }

    /**
     * 字符串分词实现
     * @param text 字符串
     * @param segment 分词实现
     * @return 实现
     * @since 0.0.5
     */
    public static IKeywordReader textSegment(final String text,
                                             final IKeywordSegment segment) {
        return new StringSegmentKeywordReader(text, segment);
    }

}
