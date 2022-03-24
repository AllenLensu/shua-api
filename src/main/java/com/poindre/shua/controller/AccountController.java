package com.poindre.shua.controller;

import com.poindre.shua.error.Response;
import com.poindre.shua.service.UserInfoService;
import com.poindre.shua.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "account")
@PreAuthorize("isAuthenticated()")
public class AccountController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "info")
    public Response<Object> userInfo(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var user = userInfoService.selectByUuid(userService.getUuid(username));
        return Response.of(true, user);
    }

    @RequestMapping(value = "test")
    public Response<String> hasLoginVerify(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        return Response.of(true, username);
    }
}
