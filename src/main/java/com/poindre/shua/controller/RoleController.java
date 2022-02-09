package com.poindre.shua.controller;

import com.poindre.shua.domain.Role;
import com.poindre.shua.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (role)表控制层
 *
 * @author Huilke
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("query")
    public Role selectOne(Short id) {
        return roleService.selectByPrimaryKey(id);
    }

}
