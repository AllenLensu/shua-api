package com.poindre.shua.tag;

import java.util.List;
import com.poindre.shua.tag.Type;
public interface TypeService{


    int deleteByPrimaryKey(Integer typeid);

    int insert(Type record);

    int insertOrUpdate(Type record);

    int insertOrUpdateSelective(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int updateBatch(List<Type> list);

    int updateBatchSelective(List<Type> list);

    int batchInsert(List<Type> list);

    List<Tag> findContentType();

    List<Menu> findMenusWithChildren();
}
