package com.shearf.cloud.apps.captcha.pub.service;

import java.util.Date;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
public interface SecurityService {

    /**
     * 验证请求是否有效，校验用户的身份与签名是否正确
     *
     * @param appKey
     * @param sign
     * @param requestTime
     * @return
     */
    boolean requestValid(String appKey, String sign, Date requestTime);
}
