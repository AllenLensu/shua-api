package com.poindre.shua.service;

import java.util.List;
import com.poindre.shua.domain.Role;
public interface RoleService{


    int deleteByPrimaryKey(Short roleid);

    int insert(Role record);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Short roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(List<Role> list);

}
