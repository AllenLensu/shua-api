package com.poindre.shua.service;

import java.util.List;
import com.poindre.shua.domain.Content;
import com.poindre.shua.domain.DetailContent;

public interface ContentService{


    int deleteByPrimaryKey(Long contentid);

    int insert(Content record);

    int insertOrUpdate(Content record);

    int insertOrUpdateSelective(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long contentid);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

    int updateBatch(List<Content> list);

    int updateBatchSelective(List<Content> list);

    int batchInsert(List<Content> list);

    List<DetailContent> findAllPosts();
}
