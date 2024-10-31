package com.github.houbb.nlp.keyword.core.model;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class KeywordFreqBean {

    /**
     * 单词信息
     * @since 0.0.1
     */
    private String word;

    /**
     * 实际频率
     * @since 0.0.1
     */
    private Double freq;

    /**
     * 构建对象实例
     * @param word 单词信息
     * @param freq 频率
     * @return 结果
     * @since 0.0.1
     */
    public static KeywordFreqBean of(final String word, final Double freq) {
        KeywordFreqBean bean = new KeywordFreqBean();
        bean.word(word).freq(freq);
        return bean;
    }

    public String word() {
        return word;
    }

    public KeywordFreqBean word(String word) {
        this.word = word;
        return this;
    }

    public Double freq() {
        return freq;
    }

    public KeywordFreqBean freq(Double freq) {
        this.freq = freq;
        return this;
    }

    @Override
    public String toString() {
        return "KeywordFreqBean{" +
                "words='" + word + '\'' +
                ", freq=" + freq +
                '}';
    }

}
