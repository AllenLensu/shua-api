package com.poindre.shua.tag;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Resource
    private TypeMapper typeMapper;

    @Override
    public int deleteByPrimaryKey(Integer typeid) {
        return typeMapper.deleteByPrimaryKey(typeid);
    }

    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Type record) {
        return typeMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Type record) {
        return typeMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    @Override
    public Type selectByPrimaryKey(Integer typeid) {
        return typeMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Type> list) {
        return typeMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Type> list) {
        return typeMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Type> list) {
        return typeMapper.batchInsert(list);
    }

    @Override
    public List<Tag> findContentType() {
        return typeMapper.findContentType();
    }

    @Override
    public List<Menu> findMenusWithChildren() {
        return typeMapper.findMenusWithChildren();
    }

}
