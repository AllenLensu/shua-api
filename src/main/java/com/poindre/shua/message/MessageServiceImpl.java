package com.poindre.shua.message;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.message.MessageMapper;
import com.poindre.shua.message.Message;
import com.poindre.shua.message.MessageService;
@Service
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(Integer mesid) {
        return messageMapper.deleteByPrimaryKey(mesid);
    }

    @Override
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Message record) {
        return messageMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Message record) {
        return messageMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Integer mesid) {
        return messageMapper.selectByPrimaryKey(mesid);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return messageMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Message> list) {
        return messageMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Message> list) {
        return messageMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Message> list) {
        return messageMapper.batchInsert(list);
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    @Override
    public List<Message> findMessage(BothSide bothSide) {
        return messageMapper.findMessage(bothSide);
    }

}
