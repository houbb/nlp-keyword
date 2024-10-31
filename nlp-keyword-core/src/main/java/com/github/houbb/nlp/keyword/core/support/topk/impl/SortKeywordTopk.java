package com.github.houbb.nlp.keyword.core.support.topk.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.nlp.keyword.api.core.IKeywordResult;
import com.github.houbb.nlp.keyword.api.model.KeywordFreqBean;
import com.github.houbb.nlp.keyword.api.support.topk.IKeywordTopk;
import com.github.houbb.nlp.keyword.core.core.KeywordResult;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 获取 topK 的算法
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class SortKeywordTopk implements IKeywordTopk {

    /**
     * 获取指定的前几个
     *
     * @param freqBeanList 频率列表（未排序）
     * @param topK         前几个信息
     * @return 结果
     * @since 0.0.1
     */
    @Override
    public List<IKeywordResult> topk(final List<KeywordFreqBean> freqBeanList,
                                     final int topK) {
        List<IKeywordResult> resultList = Guavas.newArrayList(topK);

        // 排序
        Collections.sort(freqBeanList, new Comparator<KeywordFreqBean>() {
            @Override
            public int compare(KeywordFreqBean o1, KeywordFreqBean o2) {
                return o2.freq().compareTo(o1.freq());
            }
        });

        //获取前几个
        //TODO: 抽象工具类
        for(int i = 0; i < topK; i++) {
            final KeywordFreqBean bean = freqBeanList.get(i);
            IKeywordResult result = KeywordResult.newInstance()
                    .word(bean.word())
                    .freq(bean.freq());
            resultList.add(result);
        }
        return resultList;
    }

}
