package com.poindre.shua.user.info;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserInfo record);

    int insertOrUpdate(UserInfo record);

    int insertOrUpdateSelective(UserInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserInfo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserInfo selectByPrimaryKey(String id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserInfo record);

    int updateBatch(List<UserInfo> list);

    int updateBatchSelective(List<UserInfo> list);

    int batchInsert(@Param("list") List<UserInfo> list);

    PersonalUserInfo selectByUuid(String id);

    List<UserInfo> findAllUser();

    int updateProfile(UserInfo userInfo);

    List<GlobalUserInfo> findUserInfo(UniqueUserId userId);

    List<GlobalUserInfo> getUserInfo(String uid);
}