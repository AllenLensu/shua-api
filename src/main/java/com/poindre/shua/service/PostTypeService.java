package com.poindre.shua.service;

import java.util.List;
import com.poindre.shua.domain.PostType;
public interface PostTypeService {


    int deleteByPrimaryKey(Integer typeid);

    int insert(PostType record);

    int insertOrUpdate(PostType record);

    int insertOrUpdateSelective(PostType record);

    int insertSelective(PostType record);

    PostType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(PostType record);

    int updateByPrimaryKey(PostType record);

    int updateBatch(List<PostType> list);

    int updateBatchSelective(List<PostType> list);

    int batchInsert(List<PostType> list);

}
