package com.poindre.shua.user.follow;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFollow {
    private String uuid;

    private String followedUuid;

    private Date time;
}