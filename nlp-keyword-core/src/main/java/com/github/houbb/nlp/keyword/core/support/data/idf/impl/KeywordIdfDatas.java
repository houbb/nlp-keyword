package com.github.houbb.nlp.keyword.core.support.data.idf.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.api.support.data.idf.IKeywordIdfData;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordIdfDatas {

    private KeywordIdfDatas(){}

    /**
     * 默认实现
     * @return 结果
     * @since 0.0.1
     */
    public static IKeywordIdfData defaults() {
        return Instances.singleton(KeywordIdfData.class);
    }

}
