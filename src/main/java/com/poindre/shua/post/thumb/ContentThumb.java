package com.poindre.shua.post.thumb;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
    * 适用于存储帖子的点赞信息
    */
@Data
@Builder
public class ContentThumb {
    /**
    * 适用于帖子的标识符
    */
    private Long contentId;

    /**
    * 适用于点赞帖子的个人标识符
    */
    private String uuid;

    /**
    * 适用于点赞帖子的时间
    */
    private Date time;
}