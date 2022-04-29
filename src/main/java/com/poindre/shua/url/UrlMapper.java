package com.poindre.shua.url;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlMapper {
    List<Urls> findAll();

    void insert(Urls url);

    String retrieve(String content);

    Urls deduplicate(String content);
}
