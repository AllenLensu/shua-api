package com.poindre.shua.domain;

import lombok.Data;

@Data
public class UserAccount {
    private Long id;

    private String uuid;

    private String password;

    private String avatar;
}