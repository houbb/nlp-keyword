package com.github.houbb.nlp.keyword.core.support.reader.impl;

import com.github.houbb.heaven.annotation.CommonEager;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.nlp.keyword.api.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.api.support.segment.IKeywordSegment;

import java.util.List;
import java.util.Map;

/**
 * <p> project: keyword-IKeywordReader </p>
 * <p> create on 2020/3/19 22:46 </p>
 *
 * @author binbin.hou
 * @since 0.0.5
 */
@ThreadSafe
public class StringSegmentKeywordReader implements IKeywordReader {

    /**
     * 统计数量集合
     * @since 0.0.5
     */
    private final String string;

    /**
     * 分词实现
     * @since 0.0.5
     */
    private final IKeywordSegment segment;

    /**
     * 字符串分词结果
     * @param string 字符串
     * @param segment 分词
     * @since 0.0.5
     */
    public StringSegmentKeywordReader(String string, IKeywordSegment segment) {
        this.string = string;
        this.segment = segment;
    }

    /**
     * 获取词对应的数量统计
     * @return 结果
     * @since 0.0.5
     */
    @Override
    public Map<String, Integer> wordCount() {
        // 执行分词，并累计次数和总数
        List<String> segments = segment.segment(string);

        // 次数 map
        return toCountMap(segments);
    }

    /**
     * 转换为计算总数的 map
     *
     * 1. 累计总数
     * @param segments 分词
     * @return 结果
     * @since 0.0.1
     */
    @CommonEager
    private Map<String, Integer> toCountMap(final List<String> segments) {
        Map<String, Integer> countMap = Guavas.newHashMap();

        for(String segment : segments) {
            Integer count = countMap.get(segment);

            if(ObjectUtil.isNull(count)) {
                count = 0;
            }
            count++;
            countMap.put(segment, count);
        }

        return countMap;
    }

}
