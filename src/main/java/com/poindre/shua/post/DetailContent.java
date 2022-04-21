package com.poindre.shua.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailContent {
    private Long contentid;

    private String content;

    private String uid;

    private String uuid;

    private String signature;

    private LocalDateTime sendTime;
}