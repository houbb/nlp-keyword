package com.github.houbb.nlp.keyword.similarity.util;

import com.github.houbb.nlp.keyword.similarity.bs.SimilarityBs;
import com.github.houbb.nlp.keyword.similarity.constant.SimilarityConst;
import com.github.houbb.nlp.keyword.similarity.support.reader.impl.SimilarityReaders;
import com.github.houbb.nlp.keyword.similarity.support.result.impl.SimilarityResultHandlers;

/**
 * <p> project: similarity-SimilarityHelper </p>
 * <p> create on 2020/3/14 10:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public final class SimilarityHelper {

    private SimilarityHelper(){}

    /**
     * 相似度
     * @param sourceText 原始文本
     * @param targetText 目标文本
     * @return 结果
     * @since 0.0.1
     */
    public static double similarity(final String sourceText,
                             final String targetText) {
        return similarity(sourceText, targetText, SimilarityConst.DEFAULT_KEYWORD_LIMIT);
    }

    /**
     * 相似度
     * @param sourceText 原始文本
     * @param targetText 目标文本
     * @param limit 数量限制
     * @return 结果
     * @since 0.0.1
     */
    public static double similarity(final String sourceText,
                             final String targetText,
                             final int limit) {
        return SimilarityBs.newInstance()
                .sourceReader(SimilarityReaders.string(sourceText))
                .targetReader(SimilarityReaders.string(targetText))
                .limit(limit)
                .similarity(SimilarityResultHandlers.doubles());
    }

}
