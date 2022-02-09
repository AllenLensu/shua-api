package com.poindre.shua.controller;

import com.poindre.shua.domain.UserAccount;
import com.poindre.shua.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (user_account)表控制层
*
* @author Huilke
*/
@RestController
@RequestMapping("account")
public class UserAccountController {
/**
* 服务对象
*/
@Resource
private UserAccountService userAccountService;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("query")
public UserAccount selectOne(Long id) {
return userAccountService.selectByPrimaryKey(id);
}

}
