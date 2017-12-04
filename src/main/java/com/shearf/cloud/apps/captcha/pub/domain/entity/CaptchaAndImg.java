package com.shearf.cloud.apps.captcha.pub.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
@Data
public class CaptchaAndImg implements Serializable {

    private static final long serialVersionUID = 6601445253929104565L;

    /**
     * 验证码图片地址
     */
    private String imgUrl;

    /**
     * 验证码答案
     */
    private String captcha;
}
