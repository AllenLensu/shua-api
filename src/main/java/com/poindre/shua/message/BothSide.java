package com.poindre.shua.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BothSide {

    private String uuid;

    private String chat_uuid;
}
