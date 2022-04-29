package com.poindre.shua.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Avatar {
    private String uuid;
    private String avatar;
}
