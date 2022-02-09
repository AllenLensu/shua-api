package com.poindre.shua.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.poindre.shua.mapper.RoleMapper;
import java.util.List;
import com.poindre.shua.domain.Role;
import com.poindre.shua.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Short roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Role record) {
        return roleMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Role record) {
        return roleMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Short roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Role> list) {
        return roleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Role> list) {
        return roleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Role> list) {
        return roleMapper.batchInsert(list);
    }

}
