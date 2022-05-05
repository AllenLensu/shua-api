package com.poindre.shua.account.info;

import java.util.List;
import com.poindre.shua.account.info.UserAccountInfo;
public interface UserAccountInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(UserAccountInfo record);

    int insertOrUpdate(UserAccountInfo record);

    int insertOrUpdateSelective(UserAccountInfo record);

    int insertSelective(UserAccountInfo record);

    UserAccountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAccountInfo record);

    int updateByPrimaryKey(UserAccountInfo record);

    int updateBatch(List<UserAccountInfo> list);

    int updateBatchSelective(List<UserAccountInfo> list);

    int batchInsert(List<UserAccountInfo> list);

    UserAccountInfo selectByUuid(String uuid);

    int banUser(String uuid);

    int unbanUser(String uuid);

    int deleteUser(String uuid);
}
