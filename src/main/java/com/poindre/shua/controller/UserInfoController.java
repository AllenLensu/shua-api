package com.poindre.shua.controller;

import com.poindre.shua.domain.UserInfo;
import com.poindre.shua.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (user_info)表控制层
 *
 * @author Huilke
 */
@RestController
@RequestMapping("info")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("query")
    public UserInfo selectOne(String id) {
        return userInfoService.selectByPrimaryKey(id);
    }

}
