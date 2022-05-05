package com.poindre.shua.message.list;

import com.poindre.shua.message.BothSide;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.message.list.MessageChatListMapper;
import com.poindre.shua.message.list.MessageChatList;
import com.poindre.shua.message.list.MessageChatListService;
@Service
public class MessageChatListServiceImpl implements MessageChatListService{

    @Resource
    private MessageChatListMapper messageChatListMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return messageChatListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MessageChatList record) {
        return messageChatListMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(MessageChatList record) {
        return messageChatListMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(MessageChatList record) {
        return messageChatListMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(MessageChatList record) {
        return messageChatListMapper.insertSelective(record);
    }

    @Override
    public MessageChatList selectByPrimaryKey(Integer id) {
        return messageChatListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MessageChatList record) {
        return messageChatListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MessageChatList record) {
        return messageChatListMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MessageChatList> list) {
        return messageChatListMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<MessageChatList> list) {
        return messageChatListMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<MessageChatList> list) {
        return messageChatListMapper.batchInsert(list);
    }

    @Override
    public List<String> dumpFilterHelper(String uuid) {
        return messageChatListMapper.dumpFilterHelper(uuid);
    }

    @Override
    public List<UserChatList> getChatList(String uuid) {
        return messageChatListMapper.getChatList(uuid);
    }

    @Override
    public int addChatList(AddChatList chatList) {
        return messageChatListMapper.addChatList(chatList);
    }

    @Override
    public int verifyChatExist(BothSide bothSide) {
        return messageChatListMapper.verifyChatExist(bothSide);
    }

    @Override
    public int updateTime(BothSide bothSide) {
        return messageChatListMapper.updateTime(bothSide);
    }

}
