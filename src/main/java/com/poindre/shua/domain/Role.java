package com.poindre.shua.domain;

import lombok.Data;

@Data
public class Role {
    private Short roleid;

    private String marking;

    private Boolean issystem;

    private Boolean isbind;

    private String description;
}