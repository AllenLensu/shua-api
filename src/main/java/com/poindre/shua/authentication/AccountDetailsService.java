package com.poindre.shua.authentication;

import com.poindre.shua.account.UserAccount;
import com.poindre.shua.account.UserAccountMapper;
import com.poindre.shua.account.info.UserAccountInfo;
import com.poindre.shua.account.info.UserAccountInfoMapper;
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
    @Resource
    private UserAccountInfoMapper userAccountInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.poindre.shua.user.User user = userMapper.find(username);
        if (user == null) throw new UsernameNotFoundException("Username NOT FOUND");
        UserAccount account = userAccountMapper.selectByPrimaryKey(user.getId());
        UserAccountInfo userAccountInfo = userAccountInfoMapper.selectByUuid(user.getUuid());
        if (userAccountInfo.getIsbanned()) throw new UsernameNotFoundException("User is banned");
        if (userAccountInfo.getIsDelete()) throw new UsernameNotFoundException("User is deleted");
        if (account == null) throw new UsernameNotFoundException("Account ERROR");
        //TODO 关于多种权限的管理 RBAC role based access control
        Short role = userRoleMapper.selectByUuid(user.getUuid()).getRoleId();
        return User.withUsername(user.getUid()).password(account.getPassword()).authorities(role.toString()).build();
    }
}
