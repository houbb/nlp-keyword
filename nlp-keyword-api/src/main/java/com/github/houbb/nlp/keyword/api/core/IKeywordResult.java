package com.github.houbb.nlp.keyword.api.core;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordResult {

    /**
     * 单个词信息
     * @return 词信息
     * @since 0.0.1
     */
    String word();

    /**
     * 频率
     * @return 结果
     * @since 0.0.1
     */
    double freq();
}
