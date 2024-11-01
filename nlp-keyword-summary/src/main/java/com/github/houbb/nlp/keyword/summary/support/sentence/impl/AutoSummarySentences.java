package com.github.houbb.nlp.keyword.summary.support.sentence.impl;

import com.github.houbb.nlp.keyword.summary.support.sentence.IAutoSummarySentence;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.instance.impl.Instances;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummarySentence </p>
 * <p> create on 2020/3/12 22:07 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummarySentences {

    private AutoSummarySentences(){}

    /**
     * 默认实现
     * @return 实现
     * @since 0.0.1
     */
    public static IAutoSummarySentence defaults() {
        return Instances.singleton(AutoSummarySentence.class);
    }

}
