package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.heaven.annotation.NotThreadSafe;

import java.util.Objects;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public class AutoSummaryResult implements IAutoSummaryResult {

    /**
     * 摘要句子
     * 1. 原始的句子位置
     * 2. 占用的 keyword
     * 3. 后续引入簇等概念
     * @since 0.0.2
     */
    private String sentence;

    /**
     * 句子权重
     * @since 0.0.2
     */
    private double weight;

    /**
     * 新建对象实例
     * @return 实例
     * @since 0.0.1
     */
    public static AutoSummaryResult newInstance() {
        return new AutoSummaryResult();
    }

    @Override
    public String sentence() {
        return sentence;
    }

    public AutoSummaryResult sentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    @Override
    public double weight() {
        return weight;
    }

    public AutoSummaryResult weight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return "AutoSummaryResult{" +
                "sentence='" + sentence + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AutoSummaryResult that = (AutoSummaryResult) o;
        return Double.compare(that.weight, weight) == 0 &&
                Objects.equals(sentence, that.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, weight);
    }
}
