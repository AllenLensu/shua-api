package com.poindre.shua.url;

import lombok.Data;

import java.util.Objects;

@Data
public class Urls {
    private int key;
    private String content;
    private String eigenvalue;
    private String link;

    public Urls(String content, String eigenvalue, String link) {
        this.content = content;
        this.eigenvalue = eigenvalue;
        this.link = link;
    }
}
