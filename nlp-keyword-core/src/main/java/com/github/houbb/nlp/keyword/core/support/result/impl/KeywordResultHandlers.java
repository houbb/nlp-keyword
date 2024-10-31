package com.github.houbb.nlp.keyword.core.support.result.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.nlp.keyword.api.core.IKeywordResult;
import com.github.houbb.nlp.keyword.api.support.result.IKeywordResultHandler;

import java.util.List;
import java.util.Map;

/**
 * 结果处理类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordResultHandlers {

    private KeywordResultHandlers(){}

    /**
     * 返回默认列表信息
     * @return 单词
     * @since 0.0.1
     */
    public static IKeywordResultHandler<List<IKeywordResult>> defaults() {
        return Instances.singleton(KeywordResultHandler.class);
    }

    /**
     * 返回单词列表信息
     * @return 单词
     * @since 0.0.1
     */
    public static IKeywordResultHandler<List<String>> words() {
        return Instances.singleton(KeywordResultHandlerWords.class);
    }

    /**
     * 返回单词频率 map
     * @return 单词
     * @since 0.0.4
     */
    public static IKeywordResultHandler<Map<String, Double>> freqMap() {
        return Instances.singleton(KeywordResultHandlerMap.class);
    }

}
