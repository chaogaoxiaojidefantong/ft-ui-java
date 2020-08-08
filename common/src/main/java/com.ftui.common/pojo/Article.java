package com.ftui.common.pojo;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
