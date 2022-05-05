package com.poindre.shua.user.follow;

import java.util.List;
import com.poindre.shua.user.follow.UserFollow;
public interface UserFollowService{


    int deleteByPrimaryKey(String uuid);

    int insert(UserFollow record);

    int insertOrUpdate(UserFollow record);

    int insertOrUpdateSelective(UserFollow record);

    int insertSelective(UserFollow record);

    UserFollow selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserFollow record);

    int updateByPrimaryKey(UserFollow record);

    int updateBatch(List<UserFollow> list);

    int updateBatchSelective(List<UserFollow> list);

    int batchInsert(List<UserFollow> list);

    int deleteByCompundKey(UserFollow userFollow);

    int selectByCompundKey(UserFollow userFollow);

    int getFollowNum(String uuid);

    int getTodayFollowNum(String uuid);

    int getFollowedNum(String uuid);

    int getTodayFollowedNum(String uuid);

    List<Followwed> getFollow(String uuid);

    List<Followwed> getFollowed(String uuid);

}
