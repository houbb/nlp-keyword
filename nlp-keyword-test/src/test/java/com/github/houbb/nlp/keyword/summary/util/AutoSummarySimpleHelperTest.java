package com.github.houbb.nlp.keyword.summary.util;

import com.github.houbb.heaven.util.io.FileUtil;
import org.junit.Ignore;
import org.junit.Test;

/**
 * <p> project: auto-summary-AutoSummaryHelperTest </p>
 * <p> create on 2020/3/12 22:54 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
@Ignore
public class AutoSummarySimpleHelperTest {

    @Test
    public void autoSummaryTest() {
        final String text = "你好啊，我的老伙计。最近过得怎么样？我实在是觉得太久没有看见你了。听说北海的花开了，太久没去了。";

        String summary = AutoSummaryHelper.autoSummary(text);
        System.out.println(summary);
    }

    @Test
    public void autoSummaryWeightTest() {
        final String text = FileUtil.getFileContent("D:\\_github\\auto-summary\\src\\test\\resources\\120.txt");

        String summary = AutoSummaryHelper.autoSummary(text, AutoSummaries.weight());
        System.out.println(summary);
    }

}
