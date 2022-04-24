package com.poindre.shua.post;

import lombok.Data;

import java.util.Date;

@Data
public class DetailContent {
    private Long contentid;

    private String content;

    private String uid;

    private String signature;

    private Date sendTime;

    private String avatar;
}