package com.poindre.shua.account;

import java.util.List;
import com.poindre.shua.account.UserAccount;

public interface UserAccountService{


    int deleteByPrimaryKey(Long id);

    int insert(UserAccount record);

    int insertOrUpdate(UserAccount record);

    int insertOrUpdateSelective(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

    int updateBatch(List<UserAccount> list);

    int updateBatchSelective(List<UserAccount> list);

    int batchInsert(List<UserAccount> list);

    UserAccount selectByUuid(String uuid);

}
