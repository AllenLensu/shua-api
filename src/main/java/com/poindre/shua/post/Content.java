package com.poindre.shua.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Content {
    private Long contentid;

    private String uuid;

    private String content;

    private Integer type;

    private Integer type_ex;

    private Long hot;

    private LocalDateTime sendTime;
}