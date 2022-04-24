package com.poindre.shua.post.thumb;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.post.thumb.ContentThumb;
import com.poindre.shua.post.thumb.ContentThumbMapper;
import com.poindre.shua.post.thumb.ContentThumbService;
@Service
public class ContentThumbServiceImpl implements ContentThumbService{

    @Resource
    private ContentThumbMapper contentThumbMapper;

    @Override
    public int insert(ContentThumb record) {
        return contentThumbMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ContentThumb record) {
        return contentThumbMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ContentThumb record) {
        return contentThumbMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ContentThumb record) {
        return contentThumbMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List<ContentThumb> list) {
        return contentThumbMapper.batchInsert(list);
    }

    @Override
    public int deleteByCompundKey(ContentThumb contentThumb) {
        return contentThumbMapper.deleteByCompundKey(contentThumb);
    }

    @Override
    public int selectByCompundKey(ContentThumb contentThumb) {
        return contentThumbMapper.selectByCompundKey(contentThumb);
    }

}
