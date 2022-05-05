package com.poindre.shua.message;

import java.util.Date;
import lombok.Data;

/**
    * 适用于存储用户发送的消息
    */
@Data
public class Message {
    /**
    * 适用于消息的自增序列
    */
    private Integer mesid;

    /**
    * 适用于消息的内容
    */
    private String message;

    /**
    * 适用于发送消息的用户标识码
    */
    private String send;

    /**
    * 适用于接收消息的用户标识码
    */
    private String receive;

    private Date time;
}