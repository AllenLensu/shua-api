package com.poindre.shua.user.info;

import lombok.Data;

import java.util.Date;

@Data
public class PersonalUserInfo {
    private String id;

    private String username;

    private String name;

    private Short gender;

    private Short age;

    private Date birthday;

    private String resident;

    private String household;

    private String signature;

    private String introduction;
}
