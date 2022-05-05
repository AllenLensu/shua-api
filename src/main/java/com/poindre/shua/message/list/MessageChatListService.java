package com.poindre.shua.message.list;

import java.util.List;

import com.poindre.shua.message.BothSide;
import com.poindre.shua.message.list.MessageChatList;
public interface MessageChatListService{


    int deleteByPrimaryKey(Integer id);

    int insert(MessageChatList record);

    int insertOrUpdate(MessageChatList record);

    int insertOrUpdateSelective(MessageChatList record);

    int insertSelective(MessageChatList record);

    MessageChatList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageChatList record);

    int updateByPrimaryKey(MessageChatList record);

    int updateBatch(List<MessageChatList> list);

    int updateBatchSelective(List<MessageChatList> list);

    int batchInsert(List<MessageChatList> list);

    List<String> dumpFilterHelper(String uuid);

    List<UserChatList> getChatList(String uuid);

    int addChatList(AddChatList chatList);

    int verifyChatExist(BothSide bothSide);

    int updateTime(BothSide bothSide);

}
