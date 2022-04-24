package com.poindre.shua.account;

import com.poindre.shua.account.UserAccount;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAccountMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserAccount record);

    int insertOrUpdate(UserAccount record);

    int insertOrUpdateSelective(UserAccount record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserAccount record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserAccount selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserAccount record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserAccount record);

    int updateBatch(List<UserAccount> list);

    int updateBatchSelective(List<UserAccount> list);

    int batchInsert(@Param("list") List<UserAccount> list);

    UserAccount selectByUuid(String uuid);

    String findAvatar(String uuid);
}