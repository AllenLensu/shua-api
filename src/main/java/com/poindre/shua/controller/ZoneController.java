package com.poindre.shua.controller;


import com.poindre.shua.account.Avatar;
import com.poindre.shua.account.UserAccountService;
import com.poindre.shua.banner.BannerService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.post.ContentService;
import com.poindre.shua.post.comment.ContentCommentService;
import com.poindre.shua.user.UserService;
import com.poindre.shua.user.follow.UserFollowService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("zone")
public class ZoneController {
    @Value("${avatar.path}")
    private String imageFilePath;

    @Resource
    private BannerService bannerService;
    @Resource
    private ContentCommentService contentCommentService;
    @Resource
    private UserService userService;
    @Resource
    private ContentService contentService;
    @Resource
    private UserFollowService userFollowService;
    @Resource
    private UserAccountService userAccountService;

    @RequestMapping("banner")
    public Response<Object> banner() {
        return Response.of(true, bannerService.selectAll());
    }

    @RequestMapping("{uid}/ccHistory")
    public Response<Object> ccHistory(@PathVariable String uid) {
        return Response.of(true, contentCommentService.getCommentHistory(uid));
    }

    @RequestMapping("cfHistory")
    public Response<Object> cfHistory(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, contentService.historyFavor(uuid));
    }

    @RequestMapping("ctHistory")
    public Response<Object> ctHistory(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, contentService.historyThumb(uuid));
    }

    @RequestMapping("pHistory")
    public Response<Object> pHistory(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, contentService.historyPost(uuid));
    }

    @RequestMapping("getPostNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getPostNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, contentService.getContentNum(uuid));
    }

    @RequestMapping("getTodayPostNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getTodayPostNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, contentService.getTodayContentNum(uuid));
    }

    @RequestMapping("getFollowNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFollowNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getFollowNum(uuid));
    }

    @RequestMapping("getTodayFollowNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getTodayFollowNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getTodayFollowNum(uuid));
    }

    @RequestMapping("getFollowedNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFollowedNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getFollowedNum(uuid));
    }

    @RequestMapping("getTodayFollowedNum")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getTodayFollowedNum(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getTodayFollowedNum(uuid));
    }

    @RequestMapping("avatar")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> changeAvatar(AvatarData file,@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        MultipartFile avatar = file.getFile();
        String fileType = "." + (Objects.requireNonNull(avatar.getOriginalFilename())).split("\\.")[1];
        try (FileOutputStream fileOutputStream = new FileOutputStream(imageFilePath + username + fileType)) {
            fileOutputStream.write(avatar.getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        userAccountService.updateAvatar(Avatar.builder().avatar(userDetails.getUsername() + fileType).uuid(userService.getUuid(username)).build());
        return Response.of(true, null);
    }

    @RequestMapping("getFollow")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFollow(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getFollow(uuid));
    }

    @RequestMapping("getFollowed")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFollowed(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        return Response.of(true, userFollowService.getFollowed(uuid));
    }

        @Data
    static class AvatarData {
        protected MultipartFile file;
        protected String uid;
    }
}
