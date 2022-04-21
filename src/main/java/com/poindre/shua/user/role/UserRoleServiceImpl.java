package com.poindre.shua.user.role;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserRole record) {
        return userRoleMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserRole record) {
        return userRoleMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public UserRole selectByPrimaryKey(Long id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserRole> list) {
        return userRoleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserRole> list) {
        return userRoleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserRole> list) {
        return userRoleMapper.batchInsert(list);
    }

    @Override
    public UserRole selectByUuid(String uuid) {
        return userRoleMapper.selectByUuid(uuid);
    }

}
