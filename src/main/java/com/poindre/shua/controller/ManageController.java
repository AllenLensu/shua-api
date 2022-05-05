package com.poindre.shua.controller;

import com.poindre.shua.account.info.UserAccountInfoService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.post.Content;
import com.poindre.shua.post.ContentService;
import com.poindre.shua.user.info.UserInfo;
import com.poindre.shua.user.info.UserInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/manage")
@PreAuthorize("isAuthenticated()")
public class ManageController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserAccountInfoService userAccountInfoService;
    @Resource
    private ContentService contentService;

    @RequestMapping(value = "allUser")
    public List<UserInfo> findAllUser() {
        return userInfoService.findAllUser();
    }

    @RequestMapping(value = "allPost")
    public List<Content> findAllPost() {
        return contentService.getManagePost();
    }

    @RequestMapping("{isBan}/{uuid}/ban")
    public Response<Object> handleBan(
            @PathVariable int isBan,
            @PathVariable String uuid
    ) {
        if (isBan == 0) {
            userAccountInfoService.unbanUser(uuid);
            return Response.of(true, null);
        } else {
            userAccountInfoService.banUser(uuid);
            return Response.of(true, null);
        }
    }

    @RequestMapping("{isBan}/{id}/banpost")
    public Response<Object> handlePostBan(
            @PathVariable int isBan,
            @PathVariable long id
    ) {
        if (isBan == 0) {
            contentService.unbanPost(id);
            return Response.of(true, null);
        } else {
            contentService.banPost(id);
            return Response.of(true, null);
        }
    }

    @RequestMapping("{uuid}/del")
    public Response<Object> handleDelete(
            @PathVariable String uuid
    ) {
        userAccountInfoService.deleteUser(uuid);
        return Response.of(true, null);
    }
}
