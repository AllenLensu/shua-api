package com.poindre.shua.controller;

import com.poindre.shua.authentication.BizException;
import com.poindre.shua.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("verify")
public class SecurityController {

    @RequestMapping(value = "loginSuccess")
    @ResponseBody
    public Map<String, Object> loginSuccess() {
        var result = new HashMap<String, Object>();
        result.put("name", "success");
        return result;
    }

    @RequestMapping(value = "logoutSuccess")
    @ResponseBody
    public Map<String, Object> logoutSuccess() {
        var result = new HashMap<String, Object>();
        result.put("name", "success");
        return result;
    }

    @RequestMapping(value = "loginFailure")
    @ResponseBody
    public HashMap<String, Object> loginFailure() {
        var result = new HashMap<String, Object>();
        result.put("name", "failure");
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public ErrorResponse notAuthenticated(BizException ex) {
        return ErrorResponse.of(false, ex.getMessage());
    }
}
