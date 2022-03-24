package com.poindre.shua.mapper;

import com.poindre.shua.domain.PostType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostTypMapper {
    /**
     * delete by primary key
     * @param typeid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer typeid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(PostType record);

    int insertOrUpdate(PostType record);

    int insertOrUpdateSelective(PostType record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PostType record);

    /**
     * select by primary key
     * @param typeid primary key
     * @return object by primary key
     */
    PostType selectByPrimaryKey(Integer typeid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PostType record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(PostType record);

    int updateBatch(List<PostType> list);

    int updateBatchSelective(List<PostType> list);

    int batchInsert(@Param("list") List<PostType> list);
}