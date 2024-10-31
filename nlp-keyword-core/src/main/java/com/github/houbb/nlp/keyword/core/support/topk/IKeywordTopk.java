package com.github.houbb.nlp.keyword.core.support.topk;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.model.KeywordFreqBean;

import java.util.List;

/**
 * 获取 topK 的算法
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordTopk {

    /**
     * 获取指定的前几个
     * @param freqBeanList 频率列表（未排序）
     * @param topK 前几个信息
     * @return 结果
     * @since 0.0.1
     */
    List<IKeywordResult> topk(final List<KeywordFreqBean> freqBeanList,
                              final int topK);

}
