package com.poindre.shua.user;

import com.poindre.shua.message.list.ChatList;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.poindre.shua.user.UserMapper;

import java.util.ArrayList;
import java.util.List;
import com.poindre.shua.user.User;
import com.poindre.shua.user.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(User record) {
        return userMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return userMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<User> list) {
        return userMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return userMapper.batchInsert(list);
    }

    @Override
    public String getUuid(String username) {
        return userMapper.getUuid(username);
    }

    @Override
    public int idUuidUnique(String uuid) {
        return userMapper.idUuidUnique(uuid);
    }

    @Override
    public List<User> selectByUuid(String account) {
        return userMapper.selectByUuid(account);
    }

    @Override
    public int uidUniqueVerify(String uid) {
        return userMapper.uidUniqueVerify(uid);
    }

    @Override
    public ArrayList<ChatList> loadChatlist() {
        return userMapper.loadChatlist();
    }

}
