package com.poindre.shua.user.info;

import lombok.Data;

import java.util.Date;

@Data
public class GlobalUserInfo {
    private String avatar;

    private Integer followNum;

    private Integer followedNum;

    private Short gender;

    private Date birthday;

    private String signature;

    private String introduction;
}
