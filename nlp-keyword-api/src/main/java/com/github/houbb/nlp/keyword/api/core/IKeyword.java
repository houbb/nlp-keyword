package com.github.houbb.nlp.keyword.api.core;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IKeyword {

    /**
     * 分词实现
     * @param context 上下文
     * @return 结果列表
     * @since 0.0.1
     */
    List<IKeywordResult> keyword(final IKeywordContext context);

}
