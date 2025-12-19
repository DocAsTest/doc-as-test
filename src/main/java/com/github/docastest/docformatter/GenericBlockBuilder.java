package com.github.docastest.docformatter;


public interface GenericBlockBuilder<T> {
    T title(String source_code);
    T escapeSpecialKeywords();
    T content(String content);
    String build();
}

