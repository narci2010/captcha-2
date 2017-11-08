package com.shearf.cloud.apps.captcha.pub.service;

import com.shearf.cloud.apps.captcha.pub.domain.entity.CaptchaAndImg;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
public interface CaptchaService {

    /**
     * @return 生成随机验证码和验证码图片
     */
    CaptchaAndImg getCaptcha();
}
