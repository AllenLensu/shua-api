package com.poindre.shua.banner;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.poindre.shua.banner.BannerMapper;
import com.poindre.shua.banner.Banner;
import com.poindre.shua.banner.BannerService;
@Service
public class BannerServiceImpl implements BannerService{

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Banner record) {
        return bannerMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Banner record) {
        return bannerMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerMapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Banner> list) {
        return bannerMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Banner> list) {
        return bannerMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Banner> list) {
        return bannerMapper.batchInsert(list);
    }

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

}
