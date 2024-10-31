package com.github.houbb.nlp.keyword.core.util;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.bs.KeywordBs;
import com.github.houbb.nlp.keyword.core.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.core.support.reader.impl.KeywordReaders;
import com.github.houbb.nlp.keyword.core.support.result.IKeywordResultHandler;
import com.github.houbb.nlp.keyword.core.support.result.impl.KeywordResultHandlers;
import com.github.houbb.nlp.keyword.core.support.segment.impl.KeywordSegments;

import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordHelper {

    private KeywordHelper() {
    }

    /**
     * 关键词
     *
     * @param text 读取类
     * @return 结果
     * @since 0.0.5
     */
    public static List<IKeywordResult> keyword(final String text) {
        return keyword(text, Integer.MAX_VALUE);
    }

    /**
     * 关键词
     *
     * @param text 读取类
     * @param limit 数量限制
     * @return 结果
     * @since 0.0.5
     */
    public static List<IKeywordResult> keyword(final String text, final int limit) {
        return keyword(text, limit, KeywordResultHandlers.defaults());
    }

    /**
     * 关键词
     *
     * @param text    读取类
     * @param limit   限制数量
     * @param handler 结果处理类
     * @param <R> 泛型
     * @return 结果
     * @since 0.0.5
     */
    public static <R> R keyword(final String text,
                                final int limit,
                                final IKeywordResultHandler<R> handler) {
        return keyword(KeywordReaders.textSegment(text, KeywordSegments.defaults()), limit, handler);
    }

    /**
     * 关键词
     *
     * @param countMap 总数
     * @return 结果
     * @since 0.0.5
     */
    public static List<IKeywordResult> keyword(final Map<String, Integer> countMap) {
        return keyword(KeywordReaders.wordCount(countMap), Integer.MAX_VALUE);
    }

    /**
     * 关键词
     *
     * @param countMap 总数
     * @param limit    数量限制
     * @return 结果
     * @since 0.0.5
     */
    public static List<IKeywordResult> keyword(final Map<String, Integer> countMap,
                                               final int limit) {
        return keyword(KeywordReaders.wordCount(countMap), limit);
    }

    /**
     * 关键词
     *
     * @param countMap 总数
     * @param limit    数量限制
     * @param handler 处理类
     * @param <R> 结果类
     * @return 结果
     * @since 0.0.5
     */
    public static <R> R keyword(final Map<String, Integer> countMap,
                                               final int limit,
                                               final IKeywordResultHandler<R> handler) {
        return keyword(KeywordReaders.wordCount(countMap), limit, handler);
    }

    /**
     * 关键词
     *
     * @param reader 读取类
     * @param limit  限制
     * @return 结果
     * @since 0.0.5
     */
    public static List<IKeywordResult> keyword(final IKeywordReader reader, final int limit) {
        return keyword(reader, limit, KeywordResultHandlers.defaults());
    }

    /**
     * 关键词
     *
     * @param reader  读取类
     * @param limit   限制
     * @param handler 处理类
     * @return 结果
     * @since 0.0.5
     */
    private static <R> R keyword(final IKeywordReader reader,
                                 final int limit,
                                 final IKeywordResultHandler<R> handler) {
        return KeywordBs.newInstance()
                .reader(reader)
                .limit(limit)
                .keyword(handler);
    }

}
