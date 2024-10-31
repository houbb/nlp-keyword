package com.github.houbb.nlp.keyword.core.support.segment.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.core.support.segment.IKeywordSegment;
import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.segment.mode.impl.SegmentModes;
import com.github.houbb.segment.support.segment.result.impl.SegmentResultHandlers;

import java.util.List;

/**
 * 关键词分词
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class KeywordSegment implements IKeywordSegment {

    /**
     * 分词引导类
     *
     * @since 0.0.1
     */
    private static final SegmentBs SEGMENT_BS = SegmentBs.newInstance().segmentMode(SegmentModes.all());

    @Override
    public List<String> segment(String text) {
        return SEGMENT_BS.segment(text, SegmentResultHandlers.word());
    }

}
