package com.poindre.shua.authentication;

import com.poindre.shua.account.UserAccount;
import com.poindre.shua.account.UserAccountMapper;
import com.poindre.shua.user.UserMapper;
import com.poindre.shua.user.role.UserRoleMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.poindre.shua.user.User user = userMapper.find(username);
        if (user==null) return null;
        UserAccount account = userAccountMapper.selectByPrimaryKey(user.getId());
        if (account==null) return null;
        //TODO 关于多种权限的管理 RBAC role based access control
        Short role = userRoleMapper.selectByUuid(user.getUuid()).getRoleId();
        return User.withUsername(user.getUid()).password(account.getPassword()).authorities(role.toString()).build();
    }
}
