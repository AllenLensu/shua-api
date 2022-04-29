package com.poindre.shua.post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hot {

    /**
     * @value contentid 帖子标识符
     */
    private long contentid;

    /**
     * @value hot 帖子热度
     */
    private double hot;

}
