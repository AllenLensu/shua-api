package com.poindre.shua.user;

import java.util.List;
import com.poindre.shua.user.User;
public interface UserService{


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);

    String getUuid(String username);

    int idUuidUnique(String uuid);

    List<User> selectByUuid(String account);
}
