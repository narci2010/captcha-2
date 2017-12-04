package com.shearf.cloud.apps.captcha.pub.service;

import com.shearf.cloud.apps.captcha.pub.domain.entity.CaptchaAndImg;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
public interface CaptchaService {

    /**
     * 生成随机验证码和验证码图片
     *
     * @return 验证码和验证码图片
     */
    CaptchaAndImg getCaptcha();
}
