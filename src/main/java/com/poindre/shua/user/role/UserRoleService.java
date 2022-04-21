package com.poindre.shua.user.role;

import java.util.List;

public interface UserRoleService{

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertOrUpdate(UserRole record);

    int insertOrUpdateSelective(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int updateBatch(List<UserRole> list);

    int updateBatchSelective(List<UserRole> list);

    int batchInsert(List<UserRole> list);

    UserRole selectByUuid(String uuid);

}
