package com.poindre.shua.util;

import com.poindre.shua.post.ContentService;
import com.poindre.shua.post.Hot;
import com.poindre.shua.post.comment.ContentCommentService;
import com.poindre.shua.post.favor.ContentFavorService;
import com.poindre.shua.post.thumb.ContentThumbService;
import org.springframework.stereotype.Component;

@Component
public class SocialRecommendUtils {

    private final ContentService contentService;

    private final ContentThumbService contentThumbService;

    private final ContentFavorService contentFavorService;

    private final ContentCommentService contentCommentService;

    public SocialRecommendUtils(ContentService contentService, ContentThumbService contentThumbService, ContentFavorService contentFavorService, ContentCommentService contentCommentService) {
        this.contentService = contentService;
        this.contentThumbService = contentThumbService;
        this.contentFavorService = contentFavorService;
        this.contentCommentService = contentCommentService;
    }

    public void handler(long content_id) {
        SocialRecommend sr = new SocialRecommend(content_id);
        updateSQL(updateData(sr));
    }

    public SocialRecommend updateData(SocialRecommend sr) {
        sr.setTime(contentService.getTime(sr.getContent_id()));
        sr.setCommentNum(contentCommentService.getCommentNum((int) sr.getContent_id()));
        sr.setCollectNum(contentFavorService.getFavorNum((int) sr.getContent_id()));
        sr.setLikeNum(contentThumbService.getThumbNum((int) sr.getContent_id()));
        sr.srRank();
        return sr;
    }

    public void updateSQL(SocialRecommend sr) {
        contentService.updateHot(Hot.builder().contentid(sr.getContent_id()).hot(sr.getHot()).build());
    }
}
