package com.github.houbb.nlp.keyword.similary;

import com.github.houbb.nlp.keyword.similarity.util.SimilarityHelper;
import org.junit.Test;

/**
 * <p> project: similarity-SimilarityHelperTest </p>
 * <p> create on 2020/3/14 14:40 </p>
 *
 * @author Administrator
 * @since 1.0.0
 */
public class SimilarityHelperTest {

    @Test
    public void similarityTest() {
        final String source = "我喜欢看电影，读书和旅游。";
        final String target = "我不喜欢看电影。我爱唱跳、RAP、Music~";

        double rank = SimilarityHelper.similarity(source, target);
        System.out.println(rank);
    }

    @Test
    public void similarity2Test() {
        final String source = "我喜欢看电影，读书和旅游。";
        final String target = "我喜欢看电影，读书和旅游。";

        double rank = SimilarityHelper.similarity(source, target);

        System.out.println(rank);
    }

    @Test
    public void similarity3Test() {
        final String source = "我喜欢看电影，读书和旅游。";
        final String target = "唱跳、RAP、Music~";

        double rank = SimilarityHelper.similarity(source, target);

        System.out.println(rank);
    }

}
