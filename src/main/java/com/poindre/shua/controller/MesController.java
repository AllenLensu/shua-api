package com.poindre.shua.controller;

import com.poindre.shua.handler.Response;
import com.poindre.shua.message.BothSide;
import com.poindre.shua.message.Message;
import com.poindre.shua.message.MessageService;
import com.poindre.shua.message.list.AddChatList;
import com.poindre.shua.message.list.MessageChatListService;
import com.poindre.shua.user.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("mes")
public class MesController {

    @Resource
    private UserService userService;
    @Resource
    private MessageChatListService messageChatListService;
    @Resource
    private MessageService messageService;

    @RequestMapping("/list")
    public Response<Object> getList() {
        return Response.of(true, userService.loadChatlist());
    }

    @RequestMapping("/dumpHelper")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFilter(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, messageChatListService.dumpFilterHelper(uuid));
    }

    @RequestMapping("/chatlist")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getChatList(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, messageChatListService.getChatList(uuid));
    }

    @RequestMapping("/{chatuid}/addchat")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> addChatList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable String chatuid
    ) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        var chat_uuid = userService.getUuid(chatuid);
        return Response.of(true, messageChatListService.addChatList(AddChatList.builder().uuid(uuid).chat_uuid(chat_uuid).time(new Date()).build()));
    }

    @RequestMapping("/addmes")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> addMes(
            @AuthenticationPrincipal UserDetails userDetails,
            Message message
    ) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        var char_uuid = userService.getUuid(message.getReceive());
        if (messageChatListService.verifyChatExist(BothSide.builder().chat_uuid(char_uuid).uuid(uuid).build()) == 0) {
            messageChatListService.addChatList(AddChatList.builder().uuid(char_uuid).chat_uuid(uuid).time(new Date()).build());
        }
        message.setSend(uuid);
        message.setReceive(char_uuid);
        message.setTime(new Date());
        messageChatListService.updateTime(BothSide.builder().uuid(uuid).chat_uuid(char_uuid).build());
        return Response.of(true, messageService.addMessage(message));
    }

    @RequestMapping("/{chatuid}/findmes")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> findMes(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable String chatuid
    ) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        var char_uuid = userService.getUuid(chatuid);
        return Response.of(true, messageService.findMessage(BothSide.builder().uuid(uuid).chat_uuid(char_uuid).build()));
    }

    @RequestMapping("/{uid}/getuuid")
    public String getuid(@PathVariable String uid) {
        return userService.getUuid(uid);
    }
}
