package com.poindre.shua.user.star;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
    * 适用于储存用户星标内容
    */
@Data
@Builder
public class UserStar {
    /**
    * 适用于用户的个人标识
    */
    private String uuid;

    /**
    * 适用于用户的星标列表
    */
    private Integer typeId;

    /**
    * 适用于用户星标时间
    */
    private Date time;
}