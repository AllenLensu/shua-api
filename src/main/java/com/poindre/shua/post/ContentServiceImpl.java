package com.poindre.shua.post;

import com.poindre.shua.post.comment.HistoryComment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Resource
    private ContentMapper contentMapper;

    @Override
    public List<DetailContent> findAllPosts() {
        return contentMapper.findAllPosts();
    }

    @Override
    public List<DetailContent> findTypePosts(int id) {
        return contentMapper.findTypePosts(id);
    }

    @Override
    public int insertPost(Content content) {
        return contentMapper.insertPost(content);
    }

    @Override
    public DetailContent findById(int id) {
        return contentMapper.findById(id);
    }

    @Override
    public int updateHot(Hot hot) {
        return contentMapper.updateHot(hot);
    }

    @Override
    public Date getTime(long id) {
        return contentMapper.getTime(id);
    }

    @Override
    public Double getPopularity(long id) {
        return contentMapper.getPopularity(id);
    }

    @Override
    public List<HistoryComment> historyComment(String uid) {
        return contentMapper.historyComment(uid);
    }

    @Override
    public List<DetailContent> findTypePostsTime(int id) {
        return contentMapper.findTypePostsTime(id);
    }

    @Override
    public List<DetailContent> findAllPostsTime() {
        return contentMapper.findAllPostsTime();
    }

    @Override
    public Long getPostId(String uuid) {
        return contentMapper.getPostId(uuid);
    }

    @Override
    public int getContentNum(String uuid) {
        return contentMapper.getContentNum(uuid);
    }

    @Override
    public int getTodayContentNum(String uuid) {
        return contentMapper.getTodayContentNum(uuid);
    }

    @Override
    public List<DetailContent> historyFavor(String uuid) {
        return contentMapper.historyFavor(uuid);
    }

    @Override
    public List<DetailContent> historyThumb(String uuid) {
        return contentMapper.historyThumb(uuid);
    }

    @Override
    public List<DetailContent> historyPost(String uuid) {
        return contentMapper.historyPost(uuid);
    }

    @Override
    public int deleteByPostId(Long id) {
        return contentMapper.deleteByPostId(id);
    }

}
