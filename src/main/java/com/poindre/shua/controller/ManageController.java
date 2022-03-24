package com.poindre.shua.controller;

import com.poindre.shua.domain.UserInfo;
import com.poindre.shua.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/manage")
public class ManageController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "allUser")
    public List<UserInfo> findAllUser() {
        return userInfoService.findAllUser();
    }
}
