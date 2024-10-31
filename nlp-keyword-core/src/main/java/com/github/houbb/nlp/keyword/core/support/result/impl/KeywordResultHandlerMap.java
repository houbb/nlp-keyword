package com.github.houbb.nlp.keyword.core.support.result.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.support.handler.IMapHandler;
import com.github.houbb.heaven.util.util.MapUtil;
import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.support.result.IKeywordResultHandler;

import java.util.List;
import java.util.Map;

/**
 * map 信息
 * @author binbin.hou
 * @since 0.0.4
 */
@ThreadSafe
public class KeywordResultHandlerMap implements IKeywordResultHandler<Map<String, Double>> {

    @Override
    public Map<String, Double> handler(List<IKeywordResult> results) {
        return MapUtil.toMap(results, new IMapHandler<String, Double, IKeywordResult>() {
            @Override
            public String getKey(IKeywordResult o) {
                return o.word();
            }

            @Override
            public Double getValue(IKeywordResult o) {
                return o.freq();
            }
        });
    }

}
