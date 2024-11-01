package com.github.houbb.nlp.keyword.summary.util;

import com.github.houbb.nlp.keyword.summary.api.impl.AutoSummaries;
import org.junit.Test;

/**
 * <p> project: auto-summary-AutoSummaryHelperTest </p>
 * <p> create on 2020/3/12 22:54 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public class AutoSummarySimpleHelperTest {

    public static void main(String[] args) {
        final String text = "你好啊，我的老伙计。最近过得怎么样？我实在是觉得太久没有看见你了。听说北海的花开了，太久没去了。";

        String summary = AutoSummaryHelper.autoSummary(text);
        System.out.println(summary);
    }

    @Test
    public void autoSummaryTest() {
        final String text = "你好啊，我的老伙计。最近过得怎么样？我实在是觉得太久没有看见你了。听说北海的花开了，太久没去了。故事的最后会怎么样呢？我也不清楚。";

        String summary = AutoSummaryHelper.autoSummary(text);
        System.out.println(summary);
    }

    @Test
    public void autoSummaryWeightTest() {
        final String text = "1.输入待截取的字符串和截取长度\n" +
                "在Java中，我们可以使用String类的substring方法来实现字符串的截取。\n" +
                "\n" +
                "需要注意的是，由于Java中字符串是以UTF-16编码的，因此直接使用substring方法截取可能会导致中文字符被截断。\n" +
                "\n" +
                "我们需要按字节截取字符串，可以借助Charset类来进行转换。\n" +
                "\n" +
                "  [java]\n" +
                "// 输入待截取的字符串和截取长度\n" +
                "String str = \"这是一个测试字符串\";\n" +
                "int length = 5; // 需要截取的字节长度\n" +
                "2.进行字节截取\n" +
                "我们可以通过String类的getBytes方法将字符串转换为字节数组，然后再根据截取的字节长度进行处理。\n" +
                "\n" +
                "  [java]\n" +
                "// 将字符串转换为字节数组\n" +
                "byte[] bytes = str.getBytes(\"UTF-8\");\n" +
                "\n" +
                "// 进行字节截取\n" +
                "String result = new String(bytes, 0, length, \"UTF-8\");\n" +
                "3.输出截取后的结果\n" +
                "最后，我们可以将截取后的结果输出。\n" +
                "\n" +
                "  [java]\n" +
                "// 输出截取后的结果\n" +
                "System.out.println(\"截取后的结果为：\" + result);";

        String summary = AutoSummaryHelper.autoSummary(text, AutoSummaries.weight());
        System.out.println(summary);
    }

}
