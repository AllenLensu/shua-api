package com.poindre.shua.user;

import lombok.Data;

@Data
public class User {
    /**
     * 适用于用户uuid的自增序列
     */
    private Long id;

    /**
     * 适用于用户的个人标识
     */
    private String uid;

    /**
     * 适用于用户唯一序列号的自生成uuid序列
     */
    private String uuid;
}