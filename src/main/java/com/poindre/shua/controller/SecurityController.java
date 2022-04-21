package com.poindre.shua.controller;

import com.poindre.shua.handler.BizException;
import com.poindre.shua.handler.ErrorResponse;
import com.poindre.shua.handler.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("verify")
public class SecurityController {

    @RequestMapping(value = "loginSuccess")
    @ResponseBody
    public Response<Void> loginSuccess() {
        return Response.of(true, null);
    }

    @RequestMapping(value = "logoutSuccess")
    @ResponseBody
    public Response<Void> logoutSuccess() {
        return Response.of(true, null);
    }

    @RequestMapping(value = "loginFailure")
    @ResponseBody
    public ErrorResponse loginFailure() {
        return ErrorResponse.of(false, "登录失败");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public ErrorResponse notAuthenticated(BizException ex) {
        return ErrorResponse.of(false, ex.getMessage());
    }
}
