package com.poindre.shua.post.comment;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.post.comment.ContentComment;
import com.poindre.shua.post.comment.ContentCommentMapper;
import com.poindre.shua.post.comment.ContentCommentService;
@Service
public class ContentCommentServiceImpl implements ContentCommentService{

    @Resource
    private ContentCommentMapper contentCommentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return contentCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ContentComment record) {
        return contentCommentMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ContentComment record) {
        return contentCommentMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ContentComment record) {
        return contentCommentMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ContentComment record) {
        return contentCommentMapper.insertSelective(record);
    }

    @Override
    public ContentComment selectByPrimaryKey(Long id) {
        return contentCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ContentComment record) {
        return contentCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContentComment record) {
        return contentCommentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ContentComment> list) {
        return contentCommentMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ContentComment> list) {
        return contentCommentMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ContentComment> list) {
        return contentCommentMapper.batchInsert(list);
    }

}
