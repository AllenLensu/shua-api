package com.poindre.shua.controller;

import com.poindre.shua.account.UserAccountService;
import com.poindre.shua.handler.Response;
import com.poindre.shua.post.Content;
import com.poindre.shua.post.ContentService;
import com.poindre.shua.post.DetailContent;
import com.poindre.shua.post.comment.ContentComment;
import com.poindre.shua.post.comment.ContentCommentService;
import com.poindre.shua.post.favor.ContentFavor;
import com.poindre.shua.post.favor.ContentFavorService;
import com.poindre.shua.post.thumb.ContentThumb;
import com.poindre.shua.post.thumb.ContentThumbService;
import com.poindre.shua.user.UserService;
import com.poindre.shua.user.follow.UserFollow;
import com.poindre.shua.user.follow.UserFollowService;
import com.poindre.shua.user.star.UserStar;
import com.poindre.shua.user.star.UserStarService;
import com.poindre.shua.util.SocialRecommendUtils;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("content")
public class PostController {
    @Resource
    private ContentService contentService;
    @Resource
    private UserService userService;
    @Resource
    private UserFollowService userFollowService;
    @Resource
    private ContentFavorService contentFavorService;
    @Resource
    private ContentThumbService contentThumbService;
    @Resource
    private UserStarService userStarService;
    @Resource
    private ContentCommentService contentCommentService;
    @Resource
    private UserAccountService userAccountService;
    @Resource
    private SocialRecommendUtils socialRecommendUtils;

    @GetMapping("global")
    public List<DetailContent> getGlobalPosts() {
        return contentService.findAllPosts();
    }

    @GetMapping("type")
    public List<DetailContent> getTypePosts(int id) {
        return contentService.findTypePosts(id);
    }

    @GetMapping("global/time")
    public List<DetailContent> getGlobalPostsTime() {
        return contentService.findAllPostsTime();
    }

    @GetMapping("type/time")
    public List<DetailContent> getTypePostsTime(int id) {
        return contentService.findTypePostsTime(id);
    }

    @RequestMapping("id")
    public Response<DetailContent> getIdPosts(@RequestParam("post_id") String id) {
        return Response.of(true, contentService.findById(Integer.parseInt(id)));
    }

    @RequestMapping("add")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> addPost(@AuthenticationPrincipal UserDetails userDetails, RequestCreateContentForm contentForm) {
        var username = userDetails.getUsername();
        var uuid = userService.getUuid(username);
        Content content = new Content();
        content.setContent(contentForm.getPost());
        content.setUuid(uuid);
        content.setType(contentForm.getType());
        content.setType_ex(contentForm.getType_ex());
        content.setSendTime(new Date(contentForm.getSendTime()));
        contentService.insertPost(content);
        var post_id = contentService.getPostId(uuid);
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @RequestMapping("/{followProp}/getFollowInfo")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFollowInfo(
            @PathVariable String followProp,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var followed_uuid = userService.getUuid(followProp);
        var result = userFollowService.selectByCompundKey(UserFollow.builder().uuid(uuid).followedUuid(followed_uuid).build());
        return Response.of(true, result == 1);
    }

    @RequestMapping("/{favorProp}/getFavorInfo")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getFavorInfo(
            @PathVariable String favorProp,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(favorProp);
        var result = contentFavorService.selectByCompundKey(ContentFavor.builder().uuid(uuid).contentId(post_id).build());
        return Response.of(true, result == 1);
    }

    @RequestMapping("/{thumbProp}/getThumbsInfo")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> getThumbsInfo(
            @PathVariable String thumbProp,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(thumbProp);
        var result = contentThumbService.selectByCompundKey(ContentThumb.builder().uuid(uuid).contentId(post_id).build());
        return Response.of(true, result == 1);
    }

    @RequestMapping("/star")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> star(@AuthenticationPrincipal UserDetails currentUser) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        List<UserStar> starList = userStarService.findStaredType(uuid);
        List<DetailContent> starPost = new ArrayList<>();
        for (UserStar tmp : starList) {
            starPost.addAll(contentService.findTypePosts(tmp.getTypeId()));
        }
        return Response.of(true, starPost);
    }

    @RequestMapping("/getComment/{getComment}")
    public Response<Object> getPostComment(@PathVariable String getComment) {
        return Response.of(true, contentCommentService.getComment(Integer.valueOf(getComment)));
    }

    @RequestMapping("/getCommentNum/{getCommentNum}")
    public Response<Object> getPostCommentNum(@PathVariable String getCommentNum) {
        return Response.of(true, contentCommentService.getCommentNum(Integer.valueOf(getCommentNum)));
    }

    @RequestMapping("/addComment")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> addComment(
            @AuthenticationPrincipal UserDetails currentUser,
            RequestCreateCommentForm requestCreateCommentForm
    ) {
        var currentUserUsername = currentUser.getUsername();
        Integer floor = contentCommentService.getCommentFloor(requestCreateCommentForm.post_id);
        ContentComment contentComment = new ContentComment();
        contentComment.setComment(requestCreateCommentForm.getComment());
        contentComment.setUid(currentUserUsername);
        if (requestCreateCommentForm.getComment_id_ex() != null) {
            contentComment.setEx(requestCreateCommentForm.getComment_id_ex());
        }
        if (floor == null) {
            floor = 0;
        }
        contentComment.setFloor(floor + 1);
        contentComment.setTime(new Date());
        contentComment.setContentId(requestCreateCommentForm.getPost_id().longValue());
        contentCommentService.insert(contentComment);
        socialRecommendUtils.handler(requestCreateCommentForm.getPost_id());
        return Response.of(true, null);
    }

    @RequestMapping("/detail/{id}")
    public Response<DetailContent> detailContent(@PathVariable int id) {
        return Response.of(true, contentService.findById(id));
    }

    @RequestMapping("/{uid}/avatar")
    public Response<String> getAvatar(@PathVariable String uid) {
        return Response.of(true, userAccountService.findAvatar(userService.getUuid(uid)));
    }

    @RequestMapping("/{id}/{uid}/forward")
    @PreAuthorize("isAuthenticated()")
    public Response<Object> forwardPost(
            @AuthenticationPrincipal UserDetails currentUser,
            @PathVariable long id,
            @PathVariable String uid
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        Content content = contentService.forwardGetPost(id);
        Content forward = new Content();
        forward.setUuid(uuid);
        String post_content = "[" + uid + "](http://localhost:18000/#/detail/" + id + "): " + content.getContent();
        forward.setContent(post_content);
        forward.setType(content.getType());
        forward.setType_ex(content.getType_ex());
        forward.setSendTime(new Date());
        contentService.insertPost(forward);
        var post_id = contentService.getPostId(uuid);
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @Data
    static class RequestCreateContentForm {
        private String post;
        private Integer type;
        private Integer type_ex;
        private Long sendTime;
    }

    @Data
    static class RequestCreateCommentForm {
        private Integer post_id;
        private String comment;
        private Long comment_id_ex;
    }
}
