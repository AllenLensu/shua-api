package com.poindre.shua.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.poindre.shua.mapper.UserAccountInfoMapper;
import java.util.List;
import com.poindre.shua.domain.UserAccountInfo;
import com.poindre.shua.service.UserAccountInfoService;
@Service
public class UserAccountInfoServiceImpl implements UserAccountInfoService{

    @Resource
    private UserAccountInfoMapper userAccountInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userAccountInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserAccountInfo record) {
        return userAccountInfoMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserAccountInfo record) {
        return userAccountInfoMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserAccountInfo record) {
        return userAccountInfoMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserAccountInfo record) {
        return userAccountInfoMapper.insertSelective(record);
    }

    @Override
    public UserAccountInfo selectByPrimaryKey(Long id) {
        return userAccountInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAccountInfo record) {
        return userAccountInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAccountInfo record) {
        return userAccountInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserAccountInfo> list) {
        return userAccountInfoMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserAccountInfo> list) {
        return userAccountInfoMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserAccountInfo> list) {
        return userAccountInfoMapper.batchInsert(list);
    }

}
