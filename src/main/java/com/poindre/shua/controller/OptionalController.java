package com.poindre.shua.controller;

import com.poindre.shua.handler.Response;
import com.poindre.shua.post.ContentService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("opt")
@PreAuthorize("isAuthenticated()")
public class OptionalController {
    @Resource
    private UserStarService userStarService;
    @Resource
    private UserFollowService userFollowService;
    @Resource
    private UserService userService;
    @Resource
    private ContentService contentService;
    @Resource
    private ContentFavorService contentFavorService;
    @Resource
    private ContentThumbService contentThumbService;
    @Resource
    private SocialRecommendUtils socialRecommendUtils;
    @Resource
    private ContentCommentService contentCommentService;

    @RequestMapping("/{toFollow}/follow")
    public Response<Object> followUser(
            @PathVariable String toFollow,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var followed_uuid = userService.getUuid(toFollow);
        userFollowService.insert(UserFollow.builder().uuid(uuid).followedUuid(followed_uuid).time(new Date()).build());
        return Response.of(true, null);
    }

    @RequestMapping("/{toUnfollow}/unfollow")
    public Response<Object> unfollowUser(
            @PathVariable String toUnfollow,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var followed_uuid = userService.getUuid(toUnfollow);
        userFollowService.deleteByCompundKey(UserFollow.builder().uuid(uuid).followedUuid(followed_uuid).time(new Date()).build());
        return Response.of(true, null);
    }

    @RequestMapping("/{toFavor}/favor")
    public Response<Object> favorPost(
            @PathVariable String toFavor,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(toFavor);
        contentFavorService.insert(ContentFavor.builder().contentId(post_id).uuid(uuid).time(new Date()).build());
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @RequestMapping("/{toUnfavor}/unfavor")
    public Response<Object> unfavorPost(
            @PathVariable String toUnfavor,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(toUnfavor);
        contentFavorService.deleteByCompundKey(ContentFavor.builder().contentId(post_id).uuid(uuid).time(new Date()).build());
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @RequestMapping("/{toThumbsup}/thumbsup")
    public Response<Object> thumbsupPost(
            @PathVariable String toThumbsup,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(toThumbsup);
        contentThumbService.insert(ContentThumb.builder().contentId(post_id).uuid(uuid).time(new Date()).build());
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @RequestMapping("/{toThumbsdown}/thumbsdown")
    public Response<Object> thumbsdownPost(
            @PathVariable String toThumbsdown,
            @AuthenticationPrincipal UserDetails currentUser
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        var post_id = Long.parseLong(toThumbsdown);
        contentThumbService.deleteByCompundKey(ContentThumb.builder().contentId(post_id).uuid(uuid).time(new Date()).build());
        socialRecommendUtils.handler(post_id);
        return Response.of(true, null);
    }

    @RequestMapping("/starTags")
    public Response<Object> starTags(
            @AuthenticationPrincipal UserDetails currentUser,
            @RequestParam("tagStates") ArrayList<Boolean> tagState
    ) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        for (int i = 0; i < tagState.size(); i++) {
            if (tagState.get(i) != null) {
                if (tagState.get(i)) {
                    userStarService.insertOrUpdateSelective(UserStar.builder().typeId(i).uuid(uuid).time(new Date()).build());
                } else {
                    userStarService.deleteType(UserStar.builder().typeId(i).uuid(uuid).build());
                }
            }
        }
        return Response.of(true, null);
    }

    @RequestMapping("/staredTags")
    public Response<Object> staredTags(@AuthenticationPrincipal UserDetails currentUser) {
        var currentUserUsername = currentUser.getUsername();
        var uuid = userService.getUuid(currentUserUsername);
        List<UserStar> starList = userStarService.findStaredType(uuid);
        return Response.of(true, starList);
    }

    @RequestMapping("/{id}/deletePost")
    public Response<Objects> deletePost(
            @PathVariable Long id) {
        contentService.deleteByPostId(id);
        contentFavorService.deleteByPostId(id);
        contentThumbService.deleteByPostId(id);
        contentCommentService.deleteByPostId(id);
        return Response.of(true, null);
    }
}
