package com.poindre.shua.account.info;

import com.poindre.shua.account.info.UserAccountInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAccountInfoMapper {
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
    int insert(UserAccountInfo record);

    int insertOrUpdate(UserAccountInfo record);

    int insertOrUpdateSelective(UserAccountInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserAccountInfo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserAccountInfo selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserAccountInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserAccountInfo record);

    int updateBatch(List<UserAccountInfo> list);

    int updateBatchSelective(List<UserAccountInfo> list);

    int batchInsert(@Param("list") List<UserAccountInfo> list);

    UserAccountInfo selectByUuid(String uuid);

    int banUser(String uuid);

    int unbanUser(String uuid);

    int deleteUser(String uuid);
}