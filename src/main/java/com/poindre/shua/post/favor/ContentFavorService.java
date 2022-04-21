package com.poindre.shua.post.favor;

import java.util.List;
import com.poindre.shua.post.favor.ContentFavor;
public interface ContentFavorService{


    int deleteByPrimaryKey(Long contentId);

    int insert(ContentFavor record);

    int insertOrUpdate(ContentFavor record);

    int insertOrUpdateSelective(ContentFavor record);

    int insertSelective(ContentFavor record);

    ContentFavor selectByPrimaryKey(Long contentId);

    int updateByPrimaryKeySelective(ContentFavor record);

    int updateByPrimaryKey(ContentFavor record);

    int updateBatch(List<ContentFavor> list);

    int updateBatchSelective(List<ContentFavor> list);

    int batchInsert(List<ContentFavor> list);

}
