package com.poindre.shua.tag;

import lombok.Data;

import java.util.List;

@Data
public class Tag {
    private Integer value;

    private String label;

    private List<SubTag> children;
}
