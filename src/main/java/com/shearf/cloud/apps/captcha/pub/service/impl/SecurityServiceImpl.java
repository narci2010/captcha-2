package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.shearf.cloud.apps.captcha.pub.domain.bean.ConfigValue;
import com.shearf.cloud.apps.captcha.pub.domain.model.AppAuth;
import com.shearf.cloud.apps.captcha.pub.service.AppAuthService;
import com.shearf.cloud.apps.captcha.pub.service.SecurityService;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Resource
    private ConfigValue configValue;

    @Resource
    private AppAuthService appAuthService;

    @Override
    public boolean requestValid(String appKey, String sign, Date requestTime) {
        DateTime requestDateTime = new DateTime(requestTime);
        boolean requestTimeValid = requestDateTime.plusSeconds(configValue.getRequestValidSeconds()).isAfterNow();
        if (requestTimeValid) {
            AppAuth appAuth = appAuthService.getByAppKey(appKey);
            if (appAuth != null) {
                if (AppAuth.Status.ENABLED.getCode() == appAuth.getStatus()) {
                    String encode = DigestUtils.sha1Hex(appKey + String.valueOf(requestTime.getTime()) + appAuth.getAppSecret());
                    return encode.equals(sign);
                }
            }
        }
        return false;
    }
}
