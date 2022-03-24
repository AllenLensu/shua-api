package com.poindre.shua.service.impl;

import com.poindre.shua.service.PostTypeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.poindre.shua.mapper.PostTypMapper;
import java.util.List;
import com.poindre.shua.domain.PostType;

@Service
public class PostTypeServiceImpl implements PostTypeService {

    @Resource
    private PostTypMapper postTypMapper;

    @Override
    public int deleteByPrimaryKey(Integer typeid) {
        return postTypMapper.deleteByPrimaryKey(typeid);
    }

    @Override
    public int insert(PostType record) {
        return postTypMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(PostType record) {
        return postTypMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(PostType record) {
        return postTypMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(PostType record) {
        return postTypMapper.insertSelective(record);
    }

    @Override
    public PostType selectByPrimaryKey(Integer typeid) {
        return postTypMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public int updateByPrimaryKeySelective(PostType record) {
        return postTypMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PostType record) {
        return postTypMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PostType> list) {
        return postTypMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PostType> list) {
        return postTypMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PostType> list) {
        return postTypMapper.batchInsert(list);
    }

}
