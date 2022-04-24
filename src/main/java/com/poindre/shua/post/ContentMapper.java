package com.poindre.shua.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<DetailContent> findAllPosts();

    List<DetailContent> findTypePosts(int id);

    int insertPost(Content content);

    DetailContent findById(int id);
}