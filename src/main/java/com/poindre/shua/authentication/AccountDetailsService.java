package com.poindre.shua.authentication;

import com.poindre.shua.domain.UserAccount;
import com.poindre.shua.mapper.UserAccountMapper;
import com.poindre.shua.mapper.UserMapper;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.poindre.shua.domain.User user = userMapper.find(username);
        if (user==null) return null;
        UserAccount account = userAccountMapper.selectByPrimaryKey(user.getId());
        if (account==null) return null;
        //TODO 关于多种权限的管理 RBAC role based access control
        return User.withUsername(user.getUid()).password(account.getPassword()).authorities("user").build();
    }
}
