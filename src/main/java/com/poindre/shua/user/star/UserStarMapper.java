package com.poindre.shua.user.star;

import com.poindre.shua.user.star.UserStar;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserStarMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserStar record);

    int insertOrUpdate(UserStar record);

    int insertOrUpdateSelective(UserStar record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserStar record);

    int batchInsert(@Param("list") List<UserStar> list);
}