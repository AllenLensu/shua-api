package com.poindre.shua.controller;

import com.poindre.shua.handler.Response;
import com.poindre.shua.post.Content;
import com.poindre.shua.post.ContentService;
import com.poindre.shua.post.DetailContent;
import com.poindre.shua.user.UserService;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("content")
public class PostController {
    @Resource
    private ContentService contentService;
    @Resource
    private UserService userService;

    @GetMapping("global")
    public List<DetailContent> getGlobalPosts() {
        return contentService.findAllPosts();
    }

    @GetMapping("type")
    public List<DetailContent> getTypePosts(int id) {
        return contentService.findTypePosts(id);
    }

    @RequestMapping("add")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> addPost(@AuthenticationPrincipal UserDetails userDetails,requestCreateContentForm contentForm) {
        var username = userDetails.getUsername();
        Content content = new Content();
        content.setContent(contentForm.getPost());
        content.setUuid(userService.getUuid(username));
        System.out.println(content);
        return Response.of(true, null);
    }

    @Data
    static class requestCreateContentForm {
        private String post;
        private Integer type;
        private Integer type_ex;
    }
}
