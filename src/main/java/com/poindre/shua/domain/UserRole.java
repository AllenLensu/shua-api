package com.poindre.shua.domain;

import lombok.Data;

@Data
public class UserRole {
    private Long id;

    private String userId;

    private Short roleId;
}