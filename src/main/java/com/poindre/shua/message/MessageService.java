package com.poindre.shua.message;

import java.util.List;
import com.poindre.shua.message.Message;
public interface MessageService{


    int deleteByPrimaryKey(Integer mesid);

    int insert(Message record);

    int insertOrUpdate(Message record);

    int insertOrUpdateSelective(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mesid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    int updateBatch(List<Message> list);

    int updateBatchSelective(List<Message> list);

    int batchInsert(List<Message> list);

    int addMessage(Message message);

    List<Message> findMessage(BothSide bothSide);

}
