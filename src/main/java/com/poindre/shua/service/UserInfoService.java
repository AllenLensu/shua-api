package com.poindre.shua.service;

import java.util.List;
import com.poindre.shua.domain.UserInfo;
public interface UserInfoService{


    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertOrUpdate(UserInfo record);

    int insertOrUpdateSelective(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int updateBatch(List<UserInfo> list);

    int updateBatchSelective(List<UserInfo> list);

    int batchInsert(List<UserInfo> list);

}
