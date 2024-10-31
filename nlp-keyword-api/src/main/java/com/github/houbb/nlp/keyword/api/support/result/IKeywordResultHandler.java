package com.github.houbb.nlp.keyword.api.support.result;


import com.github.houbb.nlp.keyword.api.core.IKeywordResult;

import java.util.List;

/**
 * 结果处理类
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeywordResultHandler<R> {

    /**
     * 对结果列表进行处理
     * @param results 结果列表
     * @return 处理结果
     * @since 0.0.1
     */
    R handler(final List<IKeywordResult> results);

}
