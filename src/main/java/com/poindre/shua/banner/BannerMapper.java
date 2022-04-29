package com.poindre.shua.banner;

import com.poindre.shua.banner.Banner;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BannerMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Banner record);

    int insertOrUpdate(Banner record);

    int insertOrUpdateSelective(Banner record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Banner record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Banner selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Banner record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Banner record);

    int updateBatch(List<Banner> list);

    int updateBatchSelective(List<Banner> list);

    int batchInsert(@Param("list") List<Banner> list);

    List<Banner> selectAll();
}