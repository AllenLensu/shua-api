package com.poindre.shua.message;

import com.poindre.shua.message.Message;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {
    /**
     * delete by primary key
     *
     * @param mesid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer mesid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Message record);

    int insertOrUpdate(Message record);

    int insertOrUpdateSelective(Message record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Message record);

    /**
     * select by primary key
     *
     * @param mesid primary key
     * @return object by primary key
     */
    Message selectByPrimaryKey(Integer mesid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Message record);

    int updateBatch(List<Message> list);

    int updateBatchSelective(List<Message> list);

    int batchInsert(@Param("list") List<Message> list);

    int addMessage(Message message);

    List<Message> findMessage(BothSide bothSide);
}