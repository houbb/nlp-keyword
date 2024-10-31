package com.github.houbb.nlp.keyword.core.support.topk.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.core.support.topk.IKeywordTopk;

/**
 * 获取 topK 的算法
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordTopks {

    private KeywordTopks(){}

    /**
     * 排序实现
     * @return 结果
     * @since 0.0.1
     */
    public static IKeywordTopk sort() {
        return Instances.singleton(SortKeywordTopk.class);
    }

}
