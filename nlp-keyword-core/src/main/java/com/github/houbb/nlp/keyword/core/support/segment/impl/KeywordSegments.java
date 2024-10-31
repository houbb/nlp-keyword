package com.github.houbb.nlp.keyword.core.support.segment.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.api.support.segment.IKeywordSegment;

/**
 * 关键词分词实现
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordSegments {

    private KeywordSegments(){}

    /**
     * 默认的分词实现
     * @return 分词实现
     * @since 0.0.1
     */
    public static IKeywordSegment defaults() {
        return Instances.singleton(KeywordSegment.class);
    }

}
