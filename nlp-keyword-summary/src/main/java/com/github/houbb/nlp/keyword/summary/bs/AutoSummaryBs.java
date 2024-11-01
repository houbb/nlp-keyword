package com.github.houbb.nlp.keyword.summary.bs;

import com.github.houbb.nlp.keyword.summary.api.IAutoSummary;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.api.IAutoSummaryResult;
import com.github.houbb.nlp.keyword.summary.api.impl.AutoSummaries;
import com.github.houbb.nlp.keyword.summary.api.impl.AutoSummaryContext;
import com.github.houbb.nlp.keyword.summary.constant.AutoSummaryConst;
import com.github.houbb.nlp.keyword.summary.support.keyword.IAutoSummaryKeyword;
import com.github.houbb.nlp.keyword.summary.support.keyword.impl.AutoSummaryKeywords;
import com.github.houbb.nlp.keyword.summary.support.reader.IAutoSummaryReader;
import com.github.houbb.nlp.keyword.summary.support.result.IAutoSummaryResultHandler;
import com.github.houbb.nlp.keyword.summary.support.sentence.IAutoSummarySentence;
import com.github.houbb.nlp.keyword.summary.support.sentence.impl.AutoSummarySentences;
import com.github.houbb.heaven.util.common.ArgUtil;

import java.util.List;

/**
 * <p> project: auto-summary-AutoSummaryBs </p>
 * <p> create on 2020/3/12 22:36 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public final class AutoSummaryBs {

    private AutoSummaryBs(){}

    /**
     * 新建对象实例
     * @since 0.0.1
     * @return this
     */
    public static AutoSummaryBs newInstance() {
        return new AutoSummaryBs();
    }

    /**
     * 信息读取
     * @since 0.0.1
     */
    private IAutoSummaryReader reader;

    /**
     * 句子拆分
     * @since 0.0.1
     */
    private IAutoSummarySentence sentence = AutoSummarySentences.defaults();

    /**
     * 关键词获取
     * @since 0.0.1
     */
    private IAutoSummaryKeyword keyword = AutoSummaryKeywords.defaults();

    /**
     * 自动摘要实现
     * @since 0.0.1
     */
    private IAutoSummary summary = AutoSummaries.simple();

    /**
     * 限制句子数量
     * @since 0.0.1
     */
    private int limit = AutoSummaryConst.DEFAULT_LIMIT;

    /**
     * 设置读取类
     * @param reader 读取类
     * @return this
     * @since 0.0.1
     */
    public AutoSummaryBs reader(IAutoSummaryReader reader) {
        ArgUtil.notNull(reader, "reader");

        this.reader = reader;
        return this;
    }

    /**
     * 设置断句实现
     * @param sentence 实现
     * @return this
     * @since 0.0.1
     */
    public AutoSummaryBs sentence(IAutoSummarySentence sentence) {
        ArgUtil.notNull(sentence, "sentence");

        this.sentence = sentence;
        return this;
    }

    /**
     * 设置关键字实现
     * @param keyword 实现
     * @return this
     * @since 0.0.1
     */
    public AutoSummaryBs keyword(IAutoSummaryKeyword keyword) {
        ArgUtil.notNull(keyword, "keyword");

        this.keyword = keyword;
        return this;
    }

    /**
     * 设置自动摘要实现
     * @param summary 自动摘要
     * @return this
     * @since 0.0.1
     */
    public AutoSummaryBs summary(IAutoSummary summary) {
        ArgUtil.notNull(summary, "summary");

        this.summary = summary;
        return this;
    }

    /**
     * 设置数量限制
     * @param limit 句子数量
     * @return this
     * @since 0.0.1
     */
    public AutoSummaryBs limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * 执行自动摘要
     * @param handler 处理类
     * @param <R> 泛型
     * @return 结果
     * @since 0.0.1
     */
    public <R> R autoSummary(final IAutoSummaryResultHandler<R> handler) {
        ArgUtil.notNull(handler, "handler");

        List<IAutoSummaryResult> resultList = this.summary.autoSummary(buildContext());
        return handler.handler(resultList);
    }

    /**
     * 构建上下文
     * @return 上下文
     * @since 0.0.1
     */
    private IAutoSummaryContext buildContext() {
        ArgUtil.notNull(reader, "reader");

        return AutoSummaryContext.newInstance()
                .limit(limit)
                .keyword(keyword)
                .sentence(sentence)
                .reader(reader);
    }

}
