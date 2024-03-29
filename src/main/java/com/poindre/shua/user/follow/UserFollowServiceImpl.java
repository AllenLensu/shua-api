package com.poindre.shua.user.follow;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.user.follow.UserFollow;
import com.poindre.shua.user.follow.UserFollowMapper;
import com.poindre.shua.user.follow.UserFollowService;
@Service
public class UserFollowServiceImpl implements UserFollowService{

    @Resource
    private UserFollowMapper userFollowMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return userFollowMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(UserFollow record) {
        return userFollowMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserFollow record) {
        return userFollowMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserFollow record) {
        return userFollowMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserFollow record) {
        return userFollowMapper.insertSelective(record);
    }

    @Override
    public UserFollow selectByPrimaryKey(String uuid) {
        return userFollowMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(UserFollow record) {
        return userFollowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserFollow record) {
        return userFollowMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserFollow> list) {
        return userFollowMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserFollow> list) {
        return userFollowMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserFollow> list) {
        return userFollowMapper.batchInsert(list);
    }

    @Override
    public int deleteByCompundKey(UserFollow userFollow) {
        return userFollowMapper.deleteByCompundKey(userFollow);
    }

    @Override
    public int selectByCompundKey(UserFollow userFollow) {
        return userFollowMapper.selectByCompundKey(userFollow);
    }

    @Override
    public int getFollowNum(String uuid) {
        return userFollowMapper.getFollowNum(uuid);
    }

    @Override
    public int getTodayFollowNum(String uuid) {
        return userFollowMapper.getTodayFollowNum(uuid);
    }

    @Override
    public int getFollowedNum(String uuid) {
        return userFollowMapper.getFollowedNum(uuid);
    }

    @Override
    public int getTodayFollowedNum(String uuid) {
        return userFollowMapper.getTodayFollowedNum(uuid);
    }

    @Override
    public List<Followwed> getFollow(String uuid) {
        return userFollowMapper.getFollow(uuid);
    }

    @Override
    public List<Followwed> getFollowed(String uuid) {
        return userFollowMapper.getFollowed(uuid);
    }

}
