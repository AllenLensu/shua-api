package com.poindre.shua.mapper;

import com.poindre.shua.domain.Content;
import com.poindre.shua.domain.DetailContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentMapper {
    /**
     * delete by primary key
     *
     * @param contentid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long contentid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Content record);

    int insertOrUpdate(Content record);

    int insertOrUpdateSelective(Content record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Content record);

    /**
     * select by primary key
     *
     * @param contentid primary key
     * @return object by primary key
     */
    Content selectByPrimaryKey(Long contentid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Content record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Content record);

    int updateBatch(List<Content> list);

    int updateBatchSelective(List<Content> list);

    int batchInsert(@Param("list") List<Content> list);

    List<DetailContent> findAllPosts();
}