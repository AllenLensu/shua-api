package com.poindre.shua.message.list;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AddChatList {
    private String uuid;

    private String chat_uuid;

    private Date time;
}
