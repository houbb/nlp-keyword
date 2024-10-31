package com.github.houbb.nlp.keyword.core.support.reader.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.api.support.reader.IKeywordReader;

import java.util.Map;

/**
 * <p> project: keyword-IKeywordReader </p>
 * <p> create on 2020/3/19 22:46 </p>
 *
 * @author binbin.hou
 * @since 0.0.5
 */
@ThreadSafe
public class KeywordReader implements IKeywordReader {

    /**
     * 统计数量集合
     * @since 0.0.5
     */
    private final Map<String, Integer> wordCountMap;

    public KeywordReader(Map<String, Integer> wordCountMap) {
        this.wordCountMap = wordCountMap;
    }

    /**
     * 获取词对应的数量统计
     * @return 结果
     * @since 0.0.5
     */
    @Override
    public Map<String, Integer> wordCount() {
        return this.wordCountMap;
    }

}
