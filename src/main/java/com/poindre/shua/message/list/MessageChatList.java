package com.poindre.shua.message.list;

import java.util.Date;
import lombok.Data;

/**
    * 适用于存储用户的聊天列表
    */
@Data
public class MessageChatList {
    /**
    * 适用于用户的聊天列表序列
    */
    private Integer id;

    /**
    * 适用于用户的标识符
    */
    private String uuid;

    /**
    * 适用于聊天对象的标识符
    */
    private String chatUuid;

    /**
    * 适用于排列时序
    */
    private Date time;
}