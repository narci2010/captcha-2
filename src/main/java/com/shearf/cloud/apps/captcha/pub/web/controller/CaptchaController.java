package com.shearf.cloud.apps.captcha.pub.web.controller;

import com.shearf.cloud.apps.captcha.pub.domain.entity.CaptchaAndImg;
import com.shearf.cloud.apps.captcha.pub.service.CaptchaService;
import com.shearf.cloud.apps.commons.foundation.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
@RestController
@RequestMapping("captcha")
public class CaptchaController {

    @Resource
    private CaptchaService captchaService;

    @GetMapping("/v1")
    public Response<CaptchaAndImg> getCaptcha() {
        CaptchaAndImg captchaAndImg = captchaService.getCaptcha();
        if (captchaAndImg == null) {
            return Response.fail();
        }
        return Response.success(captchaAndImg);
    }
}
