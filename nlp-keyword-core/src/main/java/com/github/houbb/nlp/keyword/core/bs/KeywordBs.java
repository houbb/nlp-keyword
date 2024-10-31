package com.github.houbb.nlp.keyword.core.bs;


import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.nlp.keyword.api.core.IKeyword;
import com.github.houbb.nlp.keyword.api.core.IKeywordContext;
import com.github.houbb.nlp.keyword.api.core.IKeywordResult;
import com.github.houbb.nlp.keyword.api.support.data.idf.IKeywordIdfData;
import com.github.houbb.nlp.keyword.api.support.filter.IKeywordFilter;
import com.github.houbb.nlp.keyword.api.support.reader.IKeywordReader;
import com.github.houbb.nlp.keyword.api.support.result.IKeywordResultHandler;
import com.github.houbb.nlp.keyword.api.support.topk.IKeywordTopk;
import com.github.houbb.nlp.keyword.core.constant.KeywordConst;
import com.github.houbb.nlp.keyword.core.core.Keyword;
import com.github.houbb.nlp.keyword.core.core.KeywordContext;
import com.github.houbb.nlp.keyword.core.support.data.idf.impl.KeywordIdfDatas;
import com.github.houbb.nlp.keyword.core.support.filter.impl.KeywordFilters;
import com.github.houbb.nlp.keyword.core.support.topk.impl.KeywordTopks;
import com.github.houbb.stoppword.core.bs.StopWord;
import com.github.houbb.stopword.api.IStopWord;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordBs {

    private KeywordBs() {
    }

    /**
     * 新建对象实例
     * @return 结果
     * @since 0.0.1
     */
    public static KeywordBs newInstance() {
        return new KeywordBs();
    }

    /**
     * 核心实现
     *
     * @since 0.0.1
     */
    private final IKeyword keyword = new Keyword();

    /**
     * 默认停顿词数据
     *
     * @since 0.0.7
     */
    private IStopWord stopWordBs = StopWord.newInstance();

    /**
     * 逆文档频率的默认实现
     *
     * @since 0.0.1
     */
    private IKeywordIdfData idfData = KeywordIdfDatas.defaults();

    /**
     * topk 算法
     * @since 0.0.1
     */
    private IKeywordTopk topk = KeywordTopks.sort();

    /**
     * 过滤实现
     * @since 0.0.2
     */
    private IKeywordFilter filter = KeywordFilters.defaults();

    /**
     * 数据读取类
     * @since 0.0.5
     */
    private IKeywordReader reader;

    /**
     * 限制数量
     * @since 0.0.5
     */
    private int limit = KeywordConst.DEFAULT_LIMIT_NUM;

    /**
     * 设置停顿词引导类
     * @param stopWordBs 引导类
     * @return this
     * @since 0.0.7
     */
    public KeywordBs stopWordBs(IStopWord stopWordBs) {
        ArgUtil.notNull(stopWordBs, "stopWord");
        this.stopWordBs = stopWordBs;
        return this;
    }

    /**
     * 设置实现类
     * @param idfData 实现类
     * @return this
     * @since 0.0.1
     */
    public KeywordBs idfData(IKeywordIdfData idfData) {
        ArgUtil.notNull(idfData, "idfData");
        this.idfData = idfData;
        return this;
    }

    /**
     * 设置实现类
     * @param topk 实现类
     * @return this
     * @since 0.0.1
     */
    public KeywordBs topk(IKeywordTopk topk) {
        ArgUtil.notNull(topk, "topk");
        this.topk = topk;
        return this;
    }

    /**
     * 设置过滤类
     * @param filter 过滤类
     * @return 结果
     * @since 0.0.2
     */
    public KeywordBs filter(IKeywordFilter filter) {
        ArgUtil.notNull(filter, "filter");

        this.filter = filter;
        return this;
    }

    /**
     * 设置读取类
     * @param reader 读取类
     * @return 实现
     * @since 0.0.5
     */
    public KeywordBs reader(IKeywordReader reader) {
        ArgUtil.notNull(reader, "reader");

        this.reader = reader;
        return this;
    }

    /**
     * 设置限制数量
     * @param limit 限制数量
     * @return 实现
     * @since 0.0.5
     */
    public KeywordBs limit(int limit) {
        this.limit = limit;
        return this;
    }

    /**
     * 关键词实现
     *
     * @param handler 处理实现类
     * @param <R> 泛型
     * @return 关键词列表
     * @since 0.0.1
     */
    public <R> R keyword(final IKeywordResultHandler<R> handler) {
        IKeywordContext context = buildContext();
        List<IKeywordResult> resultList = keyword.keyword(context);
        return handler.handler(resultList);
    }

    /**
     * 构建上下文
     *
     * @return 上下文
     * @since 0.0.1
     */
    private KeywordContext buildContext() {
        return KeywordContext.newInstance()
                .stopWordBs(stopWordBs)
                .idfData(idfData)
                .topk(topk)
                .filter(filter)
                .reader(reader)
                .limit(limit);
    }

}
