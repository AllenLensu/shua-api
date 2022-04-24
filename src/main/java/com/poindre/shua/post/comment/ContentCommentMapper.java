package com.poindre.shua.post.comment;

import com.poindre.shua.post.comment.ContentComment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContentCommentMapper {
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
    int insert(ContentComment record);

    int insertOrUpdate(ContentComment record);

    int insertOrUpdateSelective(ContentComment record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ContentComment record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ContentComment selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ContentComment record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ContentComment record);

    int updateBatch(List<ContentComment> list);

    int updateBatchSelective(List<ContentComment> list);

    int batchInsert(@Param("list") List<ContentComment> list);

    int getCommentFloor(Integer id);
}