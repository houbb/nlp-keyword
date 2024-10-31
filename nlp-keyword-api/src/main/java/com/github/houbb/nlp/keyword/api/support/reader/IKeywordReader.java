package com.github.houbb.nlp.keyword.api.support.reader;

import java.util.Map;

/**
 * <p> project: keyword-IKeywordReader </p>
 * <p> create on 2020/3/19 22:46 </p>
 *
 * @author binbin.hou
 * @since 0.0.5
 */
public interface IKeywordReader {

    /**
     * 获取词对应的数量统计
     * @return 结果
     * @since 0.0.5
     */
    Map<String, Integer> wordCount();

}
