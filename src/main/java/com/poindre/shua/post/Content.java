package com.poindre.shua.post;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Long contentid;

    private String uuid;

    private String content;

    private Integer type;

    private Integer type_ex;

    private Double hot;

    private Date sendTime;
}