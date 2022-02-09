package com.poindre.shua.controller;

import com.poindre.shua.domain.UserRole;
import com.poindre.shua.service.UserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (user_role)表控制层
 *
 * @author Huilke
 */
@RestController
@RequestMapping("permission")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("query")
    public UserRole selectOne(Long id) {
        return userRoleService.selectByPrimaryKey(id);
    }

}
