package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.support.handler.IMapHandler;
import com.github.houbb.heaven.support.tuple.impl.Pair;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.MapUtil;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.support.result.impl.KeywordResultHandlers;
import com.github.houbb.nlp.keyword.core.util.KeywordHelper;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 权重
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.2
 */
@ThreadSafe
public class AutoSummaryWeight extends AbstractAutoSummary {

    @Override
    protected List<IAutoSummaryResult> getSummaryList(List<String> sentenceList, List<IKeywordResult> keywordResults,
                                                      IAutoSummaryContext context) {
        final int limit = context.limit();
        final Map<String, Double> freqMap = MapUtil.toMap(keywordResults, new IMapHandler<String, Double, IKeywordResult>() {
            @Override
            public String getKey(IKeywordResult o) {
                return o.word();
            }

            @Override
            public Double getValue(IKeywordResult o) {
                return o.freq();
            }
        });

        //TOP-K 算法
        List<Pair<String, Double>> pairs = Guavas.newArrayList();
        for(String sentence : sentenceList) {
            double rank = calcRank(sentence, freqMap);
            Pair<String, Double> pair = Pair.of(sentence, rank);
            pairs.add(pair);
        }

        // 排序
        Collections.sort(pairs, new Comparator<Pair<String, Double>>() {
            @Override
            public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {
                return o1.getValueTwo().compareTo(o2.getValueTwo());
            }
        });

        //获取前几个
        return CollectionUtil.toList(pairs.subList(0, limit), new IHandler<Pair<String, Double>, IAutoSummaryResult>() {
            @Override
            public IAutoSummaryResult handle(Pair<String, Double> objects) {
                return AutoSummaryResult.newInstance().sentence(objects.getValueOne())
                        .weight(objects.getValueTwo());
            }
        });
    }

    /**
     * 计算评分
     * @param sentence 语句
     * @param freqMap 频率
     * @return 结果
     * @since 0.0.2
     */
    private double calcRank(final String sentence, final Map<String, Double> freqMap) {
        List<String> keywords = KeywordHelper.keyword(sentence, Integer.MAX_VALUE, KeywordResultHandlers.words());

        double result = 0.0;

        for(String keyword : keywords) {
            Double freq = freqMap.get(keyword);
            if(ObjectUtil.isNotNull(freq)) {
                result += freq;
            }
        }

        return result;
    }

}
