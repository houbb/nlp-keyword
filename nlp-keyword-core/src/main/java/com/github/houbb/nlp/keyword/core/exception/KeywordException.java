package com.github.houbb.nlp.keyword.core.exception;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class KeywordException extends RuntimeException {

    public KeywordException() {
    }

    public KeywordException(String message) {
        super(message);
    }

    public KeywordException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeywordException(Throwable cause) {
        super(cause);
    }

    public KeywordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
