package com.github.houbb.nlp.keyword.core.api.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.nlp.keyword.core.api.IKeyword;
import com.github.houbb.nlp.keyword.core.api.IKeywordContext;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.model.KeywordFreqBean;
import com.github.houbb.nlp.keyword.core.support.data.idf.IKeywordIdfData;
import com.github.houbb.nlp.keyword.core.support.filter.IKeywordFilter;
import com.github.houbb.nlp.keyword.core.support.topk.IKeywordTopk;


import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * 词频=某个词在文章中出现的次数/文章的总词数
 * TF-IDF=词频（DF）×逆文档频率（IDF）
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class Keyword implements IKeyword {

    @Override
    public List<IKeywordResult> keyword(IKeywordContext context) {
        int limit = context.limit();
        if(limit <= 0) {
            return Collections.emptyList();
        }

        // 执行分词，并累计次数和总数
        // 次数 map
        Map<String, Integer> countMap = context.reader().wordCount();

        // 映射构建 TF-IDF MAP （剔除停顿词）
        List<KeywordFreqBean> freqList = toFreqList(countMap, context);

        // 获取 top-k
        limit = Math.min(limit, freqList.size());

        final IKeywordTopk topk = context.topk();
        return topk.topk(freqList, limit);
    }

    /**
     * 转换为计算总数的 map
     *
     * 1. 累计总数
     * 2. 默认移除停顿词（放在这里减少一次循环）
     *
     *
     * TF-IDF=词频（DF）×逆文档频率（IDF）
     * @param countMap count 的 map
     * @param context 上下文
     * @return 结果
     * @since 0.0.1
     */
    private List<KeywordFreqBean> toFreqList(final Map<String, Integer> countMap,
                                             final IKeywordContext context) {
        List<KeywordFreqBean> freqBeans = Guavas.newArrayList();

        final IKeywordIdfData idfData = context.idfData();
        final IKeywordFilter filter = context.filter();

        //1. 计算 size
        double segmentSize = 0.0;
        for(Integer integer : countMap.values()) {
            segmentSize += integer;
        }

        //2. 计算权重
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            //如果是需要过滤的信息，则跳过
            final String word = entry.getKey();
            if(filter.filter(word, context)) {
                continue;
            }

            // 感觉这里除以总数，没有必要。因为都除以总数，结果还是一样的。
            // 这里数据如果后续使用标准化，那么要注意一定要大于1，不然比较时直接相互减去就会变成0。
            // 这里不进行标准化还有一个问题，如果数据较大，那么会不会直接计算溢出？
            final double tf = entry.getValue() * 1.0 / segmentSize;
            double idf = idfData.freq(word);
            double tfIdf = idf * tf ;

            freqBeans.add(KeywordFreqBean.of(word, tfIdf));
        }
        return freqBeans;
    }

}
