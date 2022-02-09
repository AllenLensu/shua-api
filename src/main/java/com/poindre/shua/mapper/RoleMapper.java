package com.poindre.shua.mapper;

import com.poindre.shua.domain.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    /**
     * delete by primary key
     *
     * @param roleid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Short roleid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Role record);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Role record);

    /**
     * select by primary key
     *
     * @param roleid primary key
     * @return object by primary key
     */
    Role selectByPrimaryKey(Short roleid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Role record);

    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(@Param("list") List<Role> list);
}