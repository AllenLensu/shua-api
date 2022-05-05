package com.poindre.shua.message.list;

import com.poindre.shua.message.BothSide;
import com.poindre.shua.message.list.MessageChatList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageChatListMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MessageChatList record);

    int insertOrUpdate(MessageChatList record);

    int insertOrUpdateSelective(MessageChatList record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MessageChatList record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MessageChatList selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MessageChatList record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MessageChatList record);

    int updateBatch(List<MessageChatList> list);

    int updateBatchSelective(List<MessageChatList> list);

    int batchInsert(@Param("list") List<MessageChatList> list);

    List<String> dumpFilterHelper(String uuid);

    List<UserChatList> getChatList(String uuid);

    int addChatList(AddChatList chatList);

    int verifyChatExist(BothSide bothSide);

    int updateTime(BothSide bothSide);
}