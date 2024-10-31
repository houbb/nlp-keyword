package com.github.houbb.nlp.keyword.core.core;


import com.github.houbb.nlp.keyword.api.core.IKeywordResult;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class KeywordResult implements IKeywordResult {

    /**
     * 单词信息
     * @since 0.0.1
     */
    private String word;

    /**
     * 频率
     * @since 0.0.1
     */
    private double freq;

    /**
     * 新建一个对象实例
     * @return 对象实例
     * @since 0.0.1
     */
    public static KeywordResult newInstance() {
        return new KeywordResult();
    }

    @Override
    public String word() {
        return word;
    }

    public KeywordResult word(String word) {
        this.word = word;
        return this;
    }

    @Override
    public double freq() {
        return freq;
    }

    public KeywordResult freq(double freq) {
        this.freq = freq;
        return this;
    }

    @Override
    public String toString() {
        return word + '|' + freq;
    }

}
