package com.poindre.shua.controller;

import com.poindre.shua.handler.Response;
import com.poindre.shua.util.SocialRecommend;
import com.poindre.shua.util.SocialRecommendUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SRRANKController {
    @Resource
    private SocialRecommendUtils  socialRecommendUtils;

    @RequestMapping("/popularity/{contentId}")
    public Response<Object> getPopularity(@RequestParam("contentId") Long contentId) {
        SocialRecommend sr = new SocialRecommend(contentId);
        socialRecommendUtils.updateSQL(socialRecommendUtils.updateData(sr));
        return Response.of(true, null);
    }
}
