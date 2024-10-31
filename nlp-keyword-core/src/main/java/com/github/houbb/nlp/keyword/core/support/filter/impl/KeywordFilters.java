package com.github.houbb.nlp.keyword.core.support.filter.impl;

import com.github.houbb.heaven.support.instance.impl.Instances;
import com.github.houbb.heaven.support.pipeline.Pipeline;
import com.github.houbb.heaven.util.util.ArrayUtil;
import com.github.houbb.nlp.keyword.api.support.filter.IKeywordFilter;

/**
 * <p> project: keyword-KeywordFilters </p>
 * <p> create on 2020/2/28 22:52 </p>
 *
 * @author Administrator
 * @since 0.0.2
 */
public final class KeywordFilters {

    private KeywordFilters(){}

    /**
     * 空
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter none() {
        return Instances.singleton(NoneKeywordFilter.class);
    }

    /**
     * 默认
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter defaults() {
        return chains(empty(), singleChar(), stopWord());
    }

    /**
     * 空
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter empty() {
        return Instances.singleton(EmptyKeywordFilter.class);
    }

    /**
     * 单个字符
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter singleChar() {
        return Instances.singleton(SingleCharKeywordFilter.class);
    }

    /**
     * 停顿词
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter stopWord() {
        return Instances.singleton(StopWordKeywordFilter.class);
    }

    /**
     * 空
     * @param filter 过滤条件
     * @param others 其他过滤条件
     * @return 结果
     * @since 0.0.2
     */
    public static IKeywordFilter chains(final IKeywordFilter filter,
                                        final IKeywordFilter... others) {

        return new AbstractKeywordFilter() {
            @Override
            protected void init(String word, Pipeline<IKeywordFilter> filterPipeline) {
                filterPipeline.addLast(filter);

                if(ArrayUtil.isNotEmpty(others)) {
                    for(IKeywordFilter other : others) {
                        filterPipeline.addLast(other);
                    }
                }
            }
        };
    }

}
