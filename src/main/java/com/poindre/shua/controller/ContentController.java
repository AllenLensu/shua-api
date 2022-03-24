package com.poindre.shua.controller;

import com.poindre.shua.domain.Content;
import com.poindre.shua.domain.DetailContent;
import com.poindre.shua.service.ContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (content)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("content")
public class ContentController {
    /**
     * 服务对象
     */
    @Resource
    private ContentService contentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Content selectOne(Long id) {
        return contentService.selectByPrimaryKey(id);
    }

    @GetMapping("global")
    public List<DetailContent> getGlobalPosts() {
        return contentService.findAllPosts();
    }
}
