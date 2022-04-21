package com.poindre.shua.post.favor;

import com.poindre.shua.post.favor.ContentFavor;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContentFavorMapper {
    /**
     * delete by primary key
     * @param contentId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long contentId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ContentFavor record);

    int insertOrUpdate(ContentFavor record);

    int insertOrUpdateSelective(ContentFavor record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ContentFavor record);

    /**
     * select by primary key
     * @param contentId primary key
     * @return object by primary key
     */
    ContentFavor selectByPrimaryKey(Long contentId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ContentFavor record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ContentFavor record);

    int updateBatch(List<ContentFavor> list);

    int updateBatchSelective(List<ContentFavor> list);

    int batchInsert(@Param("list") List<ContentFavor> list);
}