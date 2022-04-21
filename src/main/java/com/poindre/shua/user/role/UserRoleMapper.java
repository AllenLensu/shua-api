package com.poindre.shua.user.role;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
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
    int insert(UserRole record);

    int insertOrUpdate(UserRole record);

    int insertOrUpdateSelective(UserRole record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserRole record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserRole record);

    int updateBatch(List<UserRole> list);

    int updateBatchSelective(List<UserRole> list);

    int batchInsert(@Param("list") List<UserRole> list);

    UserRole selectByUuid(String uuid);
}