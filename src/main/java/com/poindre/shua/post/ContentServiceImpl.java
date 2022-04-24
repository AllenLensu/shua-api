package com.poindre.shua.post;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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

}
