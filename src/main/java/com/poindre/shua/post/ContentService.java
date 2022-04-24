package com.poindre.shua.post;

import java.util.List;

public interface ContentService{

    List<DetailContent> findAllPosts();

    List<DetailContent> findTypePosts(int id);

    int insertPost(Content content);

    DetailContent findById(int id);
}
