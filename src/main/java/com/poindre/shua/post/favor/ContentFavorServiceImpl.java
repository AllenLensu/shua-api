package com.poindre.shua.post.favor;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.post.favor.ContentFavor;
import com.poindre.shua.post.favor.ContentFavorMapper;
import com.poindre.shua.post.favor.ContentFavorService;
@Service
public class ContentFavorServiceImpl implements ContentFavorService{

    @Resource
    private ContentFavorMapper contentFavorMapper;

    @Override
    public int deleteByPrimaryKey(Long contentId) {
        return contentFavorMapper.deleteByPrimaryKey(contentId);
    }

    @Override
    public int insert(ContentFavor record) {
        return contentFavorMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ContentFavor record) {
        return contentFavorMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ContentFavor record) {
        return contentFavorMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ContentFavor record) {
        return contentFavorMapper.insertSelective(record);
    }

    @Override
    public ContentFavor selectByPrimaryKey(Long contentId) {
        return contentFavorMapper.selectByPrimaryKey(contentId);
    }

    @Override
    public int updateByPrimaryKeySelective(ContentFavor record) {
        return contentFavorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContentFavor record) {
        return contentFavorMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ContentFavor> list) {
        return contentFavorMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ContentFavor> list) {
        return contentFavorMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ContentFavor> list) {
        return contentFavorMapper.batchInsert(list);
    }

    @Override
    public int deleteByCompundKey(ContentFavor contentFavor) {
        return contentFavorMapper.deleteByCompundKey(contentFavor);
    }

    @Override
    public int selectByCompundKey(ContentFavor contentFavor) {
        return contentFavorMapper.selectByCompundKey(contentFavor);
    }

}
