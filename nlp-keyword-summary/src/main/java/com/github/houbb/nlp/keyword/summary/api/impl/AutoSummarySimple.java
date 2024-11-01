package com.github.houbb.nlp.keyword.summary.api.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;

import java.util.List;

/**
 * <p> project: auto-summary-IAutoSummary </p>
 * <p> create on 2020/3/12 21:56 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class AutoSummarySimple extends AbstractAutoSummary {

    @Override
    protected List<IAutoSummaryResult> getSummaryList(List<String> sentenceList, List<IKeywordResult> keywordResults, IAutoSummaryContext context) {
        final int limit = context.limit();
        List<IAutoSummaryResult> summaryList  = Guavas.newArrayList(limit);
        for(IKeywordResult keyword : keywordResults) {
            //1. 返回第一个包含关键字的句子。
            IAutoSummaryResult summaryResult = getFirstMatchSentence(keyword, sentenceList);
            if(ObjectUtil.isNull(summaryResult)) {
                continue;
            }

            //2. 避免句子重复
            final String sentence = summaryResult.sentence();
            if(!summaryList.contains(summaryResult)) {
                summaryList.add(summaryResult);

                //3. 列表大小判断
                if(summaryList.size() >= limit) {
                    break;
                }
            }
        }

        return summaryList;
    }


    /**
     * 获取第一个匹配的句子
     *
     * 1. 每次都从头开始读取性能一般
     * 2. 读取的不同关键词可能隶属于同一个句子，有优化的空间。
     * 3. 这种方法的权重感觉不是很合理，比较好的方式是找到最大概率的一个句子。
     *
     * @param keywordResult 关键字
     * @param sentenceList 句子列表
     * @return 第一个匹配的信息
     * @since 0.0.1
     */
    private IAutoSummaryResult getFirstMatchSentence(final IKeywordResult keywordResult,
                                         final List<String> sentenceList) {
        final String keyword = keywordResult.word();
        if(StringUtil.isEmptyTrim(keyword) || CollectionUtil.isEmpty(sentenceList)) {
            return null;
        }

        for(String sentence : sentenceList) {
            if(sentence.contains(keyword)) {
                return AutoSummaryResult.newInstance().sentence(sentence)
                        .weight(keywordResult.freq());
            }
        }
        return null;
    }

}
