package com.poindre.shua.post;

import com.poindre.shua.post.comment.HistoryComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContentMapper {

    List<DetailContent> findAllPosts();

    List<DetailContent> findTypePosts(int id);

    int insertPost(Content content);

    DetailContent findById(int id);

    int updateHot(Hot hot);

    Date getTime(long id);

    Double getPopularity(long id);

    List<HistoryComment> historyComment(String uid);

    List<DetailContent> findTypePostsTime(int id);

    List<DetailContent> findAllPostsTime();

    Long getPostId(String uuid);

    int getContentNum(String uuid);

    int getTodayContentNum(String uuid);

    List<DetailContent> historyFavor(String uuid);

    List<DetailContent> historyThumb(String uuid);

    List<DetailContent> historyPost(String uuid);

    int deleteByPostId(Long id);

    int banPost(Long id);

    int unbanPost(Long id);

    List<Content> getManagePost();

    Content forwardGetPost(Long id);
}