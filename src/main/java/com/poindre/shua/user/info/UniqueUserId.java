package com.poindre.shua.user.info;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniqueUserId {
    private String uid;
    private Long postId;
}
