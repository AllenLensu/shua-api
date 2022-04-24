package com.poindre.shua.controller;

import com.poindre.shua.user.info.UserInfo;
import com.poindre.shua.user.info.UserInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(value = "allUser")
    public List<UserInfo> findAllUser() {
        return userInfoService.findAllUser();
    }
}
