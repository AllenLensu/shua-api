package com.poindre.shua.controller;

import com.poindre.shua.domain.UserAccountInfo;
import com.poindre.shua.service.UserAccountInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (user_account_info)表控制层
 *
 * @author Huilke
 */
@RestController
@RequestMapping("profile")
public class UserAccountInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserAccountInfoService userAccountInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("query")
    public UserAccountInfo selectOne(Long id) {
        return userAccountInfoService.selectByPrimaryKey(id);
    }

}
