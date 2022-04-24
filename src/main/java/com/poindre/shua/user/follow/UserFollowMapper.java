package com.poindre.shua.user.follow;

import com.poindre.shua.user.follow.UserFollow;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserFollowMapper {
    /**
     * delete by primary key
     *
     * @param uuid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserFollow record);

    int insertOrUpdate(UserFollow record);

    int insertOrUpdateSelective(UserFollow record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserFollow record);

    /**
     * select by primary key
     *
     * @param uuid primary key
     * @return object by primary key
     */
    UserFollow selectByPrimaryKey(String uuid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserFollow record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserFollow record);

    int updateBatch(List<UserFollow> list);

    int updateBatchSelective(List<UserFollow> list);

    int batchInsert(@Param("list") List<UserFollow> list);

    int deleteByCompundKey(UserFollow userFollow);

    int selectByCompundKey(UserFollow userFollow);
}