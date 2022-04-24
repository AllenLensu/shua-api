package com.poindre.shua.user.star;

import java.util.List;
import com.poindre.shua.user.star.UserStar;
public interface UserStarService{


    int insert(UserStar record);

    int insertOrUpdate(UserStar record);

    int insertOrUpdateSelective(UserStar record);

    int insertSelective(UserStar record);

    int batchInsert(List<UserStar> list);

    List<UserStar> findStaredType(String uuid);

    int deleteType(UserStar userStar);

}
