package com.github.houbb.nlp.keyword.core.util;

import com.github.houbb.nlp.keyword.core.api.IKeywordResult;
import com.github.houbb.nlp.keyword.core.support.result.impl.KeywordResultHandlers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class KeywordHelperTest {

    /**
     * 简单测试
     * @since 0.0.5
     */
    @Test
    public void keywordSimpleTest() {
        final String text = "这是一个伸手不见五指的黑夜，夜太美。";

        List<IKeywordResult> keywords =  KeywordHelper.keyword(text);
        Assert.assertEquals("[伸手不见|0.86879235325, 太美|0.70848301840625, 伸手不见五指|0.63371734601875, 黑夜|0.509854654010625, 伸手|0.43563643037625, 一个|0.176096935758125]", keywords.toString());
    }

    /**
     * 简单测试
     * @since 0.0.5
     */
    @Test
    public void keywordSimpleSizeTest() {
        final String text = "这是一个伸手不见五指的黑夜，夜太美。";

        List<IKeywordResult> keywords =  KeywordHelper.keyword(text, 1);
        Assert.assertEquals("[伸手不见|0.86879235325]", keywords.toString());
    }

    /**
     * 简单测试
     * @since 0.0.5
     */
    @Test
    public void keywordSimpleWordTest() {
        final String text = "这是一个伸手不见五指的黑夜，夜太美。";

        List<String> keywords =  KeywordHelper.keyword(text, 1, KeywordResultHandlers.words());
        Assert.assertEquals("[伸手不见]", keywords.toString());
    }


    /**
     * 简单测试
     * @since 0.0.1
     */
    @Test
    public void keywordTest() {
        final String text = "这是一个伸手不见五指的黑夜，夜太美。";

        List<String> keywords =  KeywordHelper.keyword(text, 5, KeywordResultHandlers.words());
        Assert.assertEquals("[伸手不见, 太美, 伸手不见五指, 黑夜, 伸手]", keywords.toString());
    }

    /**
     * 简单测试-设置限制数量
     * @since 0.0.1
     */
    @Test
    public void keywordWithLimitTest() {
        final String text = "这是一个伸手不见五指的黑夜，夜太美。";

        List<String> keywords =  KeywordHelper.keyword(text, 3, KeywordResultHandlers.words());
        Assert.assertEquals("[伸手不见, 太美, 伸手不见五指]", keywords.toString());
    }

}
