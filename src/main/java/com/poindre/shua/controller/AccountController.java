package com.poindre.shua.controller;

import com.poindre.shua.account.UserAccountService;
import com.poindre.shua.account.info.UserAccountInfo;
import com.poindre.shua.account.info.UserAccountInfoService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.user.info.UserInfoService;
import com.poindre.shua.user.UserService;
import com.poindre.shua.user.role.UserRoleService;
import lombok.Data;
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
    @Resource
    private UserAccountService userAccountService;
    @Resource
    private UserAccountInfoService userAccountInfoService;
    @Resource
    private UserRoleService userRoleService;

    @RequestMapping("info")
    public Response<Object> userInfo(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var user = userInfoService.selectByUuid(userService.getUuid(username));
        return Response.of(true, user);
    }

    @RequestMapping("test")
    public Response<UsernameWithAvatar> hasLoginVerify(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        var avatar = "/avatar/" + userAccountService.selectByUuid(uuid).getAvatar();
        var role = userRoleService.selectByUuid(uuid);
        return Response.of(true, new UsernameWithAvatar(username, avatar, Integer.valueOf(role.getRoleId())));
    }

    @RequestMapping("profile")
    public Response<UserAccountInfo> profile(@AuthenticationPrincipal UserDetails userDetails) {
        var username = userDetails.getUsername();
        UserAccountInfo userAccountInfo = userAccountInfoService.selectByUuid(userService.getUuid(username));
        return Response.of(true, userAccountInfo);
    }

    @Data
    protected static class UsernameWithAvatar {
        private String username;
        private String avatar;
        private Integer accountRole;

        public UsernameWithAvatar(String username, String avatar, Integer role) {
            setAvatar(avatar);
            setUsername(username);
            setAccountRole(role);
        }
    }
}
