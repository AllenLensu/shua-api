package com.poindre.shua.controller;

import com.poindre.shua.tag.Menu;
import com.poindre.shua.tag.Tag;
import com.poindre.shua.tag.Type;
import com.poindre.shua.tag.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Resource
    private TypeService typeService;

    @GetMapping("global")
    public List<Menu> getCurrentMenu() {
        return typeService.findMenusWithChildren();
    }

    @GetMapping("all")
    public List<Tag> getAllTypes() {
        return typeService.findContentType();
    }
}
