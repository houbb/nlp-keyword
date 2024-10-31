package com.github.houbb.nlp.keyword.core.support.data.idf.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.guava.Guavas;
import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.nlp.keyword.core.constant.KeywordConst;
import com.github.houbb.nlp.keyword.core.support.data.idf.IKeywordIdfData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class KeywordIdfData implements IKeywordIdfData {

    /**
     * 频率
     * @since 0.0.1
     */
    private static final Map<String, Double> FREQ_MAP;

    /**
     * 默认使用平均值
     * @since 0.0.1
     */
    private static double medianFreq = 1.0;

    static {
        List<String> lines = StreamUtil.readAllLines(KeywordConst.SYSTEM_IDF_DICT_PATH);

        FREQ_MAP = Guavas.newHashMap(lines.size());
        BigDecimal freqTotal = new BigDecimal(0);
        for(String line : lines) {
            if(StringUtil.isEmptyTrim(line)) {
                continue;
            }

            String[] entries = line.split(StringUtil.BLANK);
            String key = entries[0];
            double freq = Double.parseDouble(entries[1]);
            FREQ_MAP.put(key, freq);

            // 这里的比较会导致初始化慢那么一点
            freqTotal = freqTotal.add(new BigDecimal(freq));
        }

        final int size = FREQ_MAP.size();
        if(size > 0) {
            medianFreq = freqTotal.divide(new BigDecimal(lines.size()), BigDecimal.ROUND_DOWN).doubleValue();
        }
    }

    /**
     * 当前词的逆文档频率
     * （1）如果不存在这个词，则直接返回最大值。
     * 说明这个值很不常见
     * <p>
     * （2）如果存在，则正常返回对应值即可。
     *
     * @param word 当前词
     * @return 是否
     * @since 0.0.1
     */
    @Override
    public double freq(final String word) {
        Double freq = FREQ_MAP.get(word);

        if(freq != null) {
            return freq;
        }
        return medianFreq;
    }

}
