package com.github.houbb.nlp.keyword.summary.support.sentence.impl;

import com.github.houbb.nlp.keyword.summary.support.sentence.IAutoSummarySentence;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.sentence.segment.support.result.impl.SentenceSegmentResultHandlers;
import com.github.houbb.sentence.segment.util.SentenceSegmentHelper;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummarySentence </p>
 * <p> create on 2020/3/12 22:07 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class AutoSummarySentence implements IAutoSummarySentence {

    /**
     * 断句
     * @param text 原始文本
     * @return 结果列表
     * @since 0.0.1
     */
    @Override
    public List<String> sentence(final String text) {
        return SentenceSegmentHelper.segment(text, SentenceSegmentResultHandlers.sentenceTrim());
    }

}
