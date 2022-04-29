package com.poindre.shua.post.thumb;

import java.util.List;
import com.poindre.shua.post.thumb.ContentThumb;
public interface ContentThumbService{


    int insert(ContentThumb record);

    int insertOrUpdate(ContentThumb record);

    int insertOrUpdateSelective(ContentThumb record);

    int insertSelective(ContentThumb record);

    int batchInsert(List<ContentThumb> list);

    int deleteByCompundKey(ContentThumb contentThumb);

    int selectByCompundKey(ContentThumb contentThumb);

    int getThumbNum(int id);

    int deleteByPostId(Long id);
}
