package com.github.houbb.nlp.keyword.core.support.result.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IHandler;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.nlp.keyword.api.core.IKeywordResult;
import com.github.houbb.nlp.keyword.api.support.result.IKeywordResultHandler;

import java.util.List;

/**
 * 结果处理类
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class KeywordResultHandlerWords implements IKeywordResultHandler<List<String>> {

    /**
     * 对结果列表进行处理
     *
     * @param results 结果列表
     * @return 处理结果
     * @since 0.0.1
     */
    @Override
    public List<String> handler(final List<IKeywordResult> results) {
        return CollectionUtil.toList(results, new IHandler<IKeywordResult, String>() {
            @Override
            public String handle(IKeywordResult iKeywordResult) {
                return iKeywordResult.word();
            }
        });
    }

}
