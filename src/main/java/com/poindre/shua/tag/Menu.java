package com.poindre.shua.tag;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;

    private String tag;

    private String description;

    private String icon;

    private List<SubMenu> submenus;
}
