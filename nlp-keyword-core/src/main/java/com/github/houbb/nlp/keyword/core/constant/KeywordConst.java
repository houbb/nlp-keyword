package com.github.houbb.nlp.keyword.core.constant;

/**
 * 关键词常量
 * @author binbin.hou
 * @since 0.0.1
 */
public final class KeywordConst {

    private KeywordConst(){}

    /**
     * 停顿词默认文件路径
     * @since 0.0.1
     */
    public static final String SYSTEM_STOP_WORDS_PATH = "/keyword_stop_words.txt";

    /**
     * 自定义停顿词默认文件路径
     * @since 0.0.3
     */
    public static final String DEFINE_STOP_WORDS_PATH = "/keyword_stop_words_define.txt";

    /**
     * 系统内置逆向频率文档
     *
     * 逆文档频率=log(语料库的文档总数/包含该词的文档数+1)
     *
     * 如果一个词越常见，那么分母就越大，逆文档频率就越小越接近0。
     * 分母之所以要加1，是为了避免分母为0（即所有文档都不包含该词）。
     * log表示对得到的值取对数。
     *
     * @since 0.0.1
     */
    public static final String SYSTEM_IDF_DICT_PATH = "/keyword_idf_dict.txt";

    /**
     * 默认限制数量
     * @since 0.0.1
     */
    public static final int DEFAULT_LIMIT_NUM = 5;

}
