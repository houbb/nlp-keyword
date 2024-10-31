package com.github.houbb.nlp.keyword.core.support.data.idf;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordIdfData {

    /**
     * 当前词的逆文档频率
     * （1）如果不存在这个词，则直接返回最大值。
     * 说明这个值很不常见
     *
     * （2）如果存在，则正常返回对应值即可。
     *
     * @param word 当前词
     * @return 是否
     * @since 0.0.1
     */
    double freq(final String word);

}
