package com.poindre.shua.service.impl;

import com.poindre.shua.domain.UserAccount;
import com.poindre.shua.mapper.UserAccountMapper;
import com.poindre.shua.service.UserAccountService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Resource
    private UserAccountMapper userAccountMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserAccount record) {
        return userAccountMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserAccount record) {
        return userAccountMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserAccount record) {
        return userAccountMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserAccount record) {
        return userAccountMapper.insertSelective(record);
    }

    @Override
    public UserAccount selectByPrimaryKey(Long id) {
        return userAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAccount record) {
        return userAccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAccount record) {
        return userAccountMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserAccount> list) {
        return userAccountMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserAccount> list) {
        return userAccountMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserAccount> list) {
        return userAccountMapper.batchInsert(list);
    }

}
