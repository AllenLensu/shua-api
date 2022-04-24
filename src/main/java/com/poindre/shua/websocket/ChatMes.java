package com.poindre.shua.websocket;

import lombok.Data;

import java.util.Date;

@Data
public class ChatMes {

    /**
     * 发送者
     */
    private Integer userId;
    /**
     * id
     */
    private Integer cId;
    /**
     * 头像
     */
    private String userIocn;
    /**
     * 内容
     */
    private String cltext;
    /**
     * 时间
     */
    private Date createtime;
    /**
     * 0是未读
     */
    private String clstate;
    /**
     * 0是自己  1是对方
     */
    private String tpye;
}
