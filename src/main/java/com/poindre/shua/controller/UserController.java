package com.poindre.shua.controller;

import com.poindre.shua.domain.User;
import com.poindre.shua.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (user)表控制层
 *
 * @author Huilke
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("query")
    public User selectOne(Long id) {
        return userService.selectByPrimaryKey(id);
    }

}
