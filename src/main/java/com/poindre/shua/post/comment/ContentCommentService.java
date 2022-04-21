package com.poindre.shua.post.comment;

import java.util.List;
import com.poindre.shua.post.comment.ContentComment;
public interface ContentCommentService{


    int deleteByPrimaryKey(Long id);

    int insert(ContentComment record);

    int insertOrUpdate(ContentComment record);

    int insertOrUpdateSelective(ContentComment record);

    int insertSelective(ContentComment record);

    ContentComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentComment record);

    int updateByPrimaryKey(ContentComment record);

    int updateBatch(List<ContentComment> list);

    int updateBatchSelective(List<ContentComment> list);

    int batchInsert(List<ContentComment> list);

}
