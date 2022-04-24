package com.poindre.shua.post.comment;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
    * 适用于存储用户的评论
    */
@Data
public class Comment {
    /**
    * 适用于评论的标识符
    */
    private Long id;

    /**
    * 适用于评论的帖子标识符
    */
    private Long contentId;

    /**
    * 适用于发布评论的用户个人标识符
    */
    private String uid;

    /**
    * 适用于评论序列号
    */
    private Integer floor;

    /**
    * 适用于发布评论的时间
    */
    private Date time;

    /**
    * 适用于评论的内容
    */
    private String comment;

    private List<SubComment> subComments;
}