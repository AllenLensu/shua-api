package com.poindre.shua.service.impl;

import com.poindre.shua.domain.DetailContent;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.domain.Content;
import com.poindre.shua.mapper.ContentMapper;
import com.poindre.shua.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService{

    @Resource
    private ContentMapper contentMapper;

    @Override
    public int deleteByPrimaryKey(Long contentid) {
        return contentMapper.deleteByPrimaryKey(contentid);
    }

    @Override
    public int insert(Content record) {
        return contentMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Content record) {
        return contentMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Content record) {
        return contentMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Content record) {
        return contentMapper.insertSelective(record);
    }

    @Override
    public Content selectByPrimaryKey(Long contentid) {
        return contentMapper.selectByPrimaryKey(contentid);
    }

    @Override
    public int updateByPrimaryKeySelective(Content record) {
        return contentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Content record) {
        return contentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Content> list) {
        return contentMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Content> list) {
        return contentMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Content> list) {
        return contentMapper.batchInsert(list);
    }

    @Override
    public List<DetailContent> findAllPosts() {
        return contentMapper.findAllPosts();
    }

}
