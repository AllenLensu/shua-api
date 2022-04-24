package com.poindre.shua.post.favor;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
    * 适用于存储帖子的收藏信息
    */
@Data
@Builder
public class ContentFavor {
    private Long contentId;

    /**
    * 适用于存储收藏帖子的用户个人标识符
    */
    private String uuid;

    /**
    * 适用于存储收藏时间
    */
    private Date time;
}