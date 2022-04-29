package com.poindre.shua.controller;

import com.poindre.shua.url.UrlMapper;
import com.poindre.shua.url.Urls;
import com.poindre.shua.util.CharacteristicValue;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("s")
@CrossOrigin
public class UrlController {
    @Resource
    private UrlMapper urlMapper;

    public UrlController(UrlMapper urlMapper) {
        this.urlMapper = urlMapper;
    }

    @RequestMapping(value = "c")
    @ResponseBody
    public String shorter(Url url) {
        Urls urlObj = urlMapper.deduplicate(url.getUrl());
        if (urlObj == null) {
            CharacteristicValue cv = new CharacteristicValue(url.getUrl());
            String result = String.valueOf(cv.getEigenvalue());
            Urls object = new Urls(url.getUrl(), result, "http://localhost:18080/s/re?v=" + result);
            urlMapper.insert(object);
            return object.getLink();
        } else {
            return urlObj.getLink();
        }
    }

    @RequestMapping(value = "f")
    @ResponseBody
    public List<Urls> findAll() {
        return urlMapper.findAll();
    }

    @GetMapping(value = "re")
    public void redirect(String v, HttpServletResponse response) throws IOException {
        response.sendRedirect(urlMapper.retrieve(v));
    }

    @Data
    static class Url {
        String url;
    }
}
