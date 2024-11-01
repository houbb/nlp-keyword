package com.github.houbb.nlp.keyword.similarity.support.keyword.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.support.result.impl.KeywordResultHandlers;
import com.github.houbb.nlp.keyword.core.util.KeywordHelper;
import com.github.houbb.nlp.keyword.similarity.support.keyword.ISimilarityKeyword;

import java.util.List;
import java.util.Map;

/**
 * <p> project: auto-summary-IAutoSummaryKeyword </p>
 * <p> create on 2020/3/12 22:00 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class SimilarityKeyword implements ISimilarityKeyword {

    @Override
    public List<IKeywordResult> keywordList(String text, int limit) {
        return KeywordHelper.keyword(text, limit);
    }

    @Override
    public Map<String, Double> keywordMap(String text, int limit) {
        return KeywordHelper.keyword(text, limit, KeywordResultHandlers.freqMap());
    }

}
