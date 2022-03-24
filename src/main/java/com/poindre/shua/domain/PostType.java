package com.poindre.shua.domain;

import lombok.Data;

@Data
public class PostType {
    private Integer typeid;

    private String tag;

    private String description;

    private Integer ex;
}