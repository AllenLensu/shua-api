package com.poindre.shua.post.thumb;

import com.poindre.shua.post.thumb.ContentThumb;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContentThumbMapper {
    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(ContentThumb record);

    int insertOrUpdate(ContentThumb record);

    int insertOrUpdateSelective(ContentThumb record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ContentThumb record);

    int batchInsert(@Param("list") List<ContentThumb> list);

    int deleteByCompundKey(ContentThumb contentThumb);

    int selectByCompundKey(ContentThumb contentThumb);

    int getThumbNum(int id);

    int deleteByPostId(Long id);
}