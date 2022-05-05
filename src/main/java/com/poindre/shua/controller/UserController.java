package com.poindre.shua.controller;

import com.poindre.shua.account.info.UserAccountInfoService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.post.ContentService;
import com.poindre.shua.user.UserService;
import com.poindre.shua.user.info.UniqueUserId;
import com.poindre.shua.user.info.UserInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ContentService contentService;
    @Resource
    private UserService userService;
    @Resource
    private UserAccountInfoService userAccountInfoService;

    @RequestMapping("{uid}/{postId}/info")
    public Response<Object> getUserInfo(
            @PathVariable String uid,
            @PathVariable long postId
    ) {
        return Response.of(true, userInfoService.findUserInfo(UniqueUserId.builder().postId(postId).uid(uid).build()));
    }

    @RequestMapping("{uid}/info")
    public Response<Object> findUserInfo(
            @PathVariable String uid
    ) {
        return Response.of(true, userInfoService.getUserInfo(uid));
    }

    @RequestMapping("{uid}/post")
    public Response<Object> getUserPost(
            @PathVariable String uid
    ) {
        return Response.of(true, contentService.historyPost(userService.getUuid(uid)));
    }

    @RequestMapping("cancellate")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> deleteUserself(
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        userAccountInfoService.deleteUser(uuid);
        return Response.of(true, null);
    }
}
