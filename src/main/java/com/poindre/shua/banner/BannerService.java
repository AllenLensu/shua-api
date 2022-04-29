package com.poindre.shua.banner;

import java.util.List;
import com.poindre.shua.banner.Banner;
public interface BannerService{


    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertOrUpdate(Banner record);

    int insertOrUpdateSelective(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    int updateBatch(List<Banner> list);

    int updateBatchSelective(List<Banner> list);

    int batchInsert(List<Banner> list);

    List<Banner> selectAll();

}
