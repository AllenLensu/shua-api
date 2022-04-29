package com.poindre.shua.post.comment;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryComment {
    private Long contentid;

    private String content;

    private String uid;

    private String signature;

    private Date sendTime;

    private String avatar;

    private String comment;

    private Date commentTime;
}