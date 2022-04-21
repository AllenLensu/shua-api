package com.poindre.shua.user.star;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.user.star.UserStarMapper;
import com.poindre.shua.user.star.UserStar;
import com.poindre.shua.user.star.UserStarService;
@Service
public class UserStarServiceImpl implements UserStarService{

    @Resource
    private UserStarMapper userStarMapper;

    @Override
    public int insert(UserStar record) {
        return userStarMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserStar record) {
        return userStarMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserStar record) {
        return userStarMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserStar record) {
        return userStarMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List<UserStar> list) {
        return userStarMapper.batchInsert(list);
    }

}
