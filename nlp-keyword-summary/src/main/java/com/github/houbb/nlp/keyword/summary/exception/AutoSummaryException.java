package com.github.houbb.nlp.keyword.summary.exception;

/**
 * <p> project: auto-summary-AutoSummaryException </p>
 * <p> create on 2020/3/12 21:58 </p>
 *
 * @author binbin.hou
 * @since 0.0.1
 */
public class AutoSummaryException extends RuntimeException {

    public AutoSummaryException() {
    }

    public AutoSummaryException(String message) {
        super(message);
    }

    public AutoSummaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutoSummaryException(Throwable cause) {
        super(cause);
    }

    public AutoSummaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
