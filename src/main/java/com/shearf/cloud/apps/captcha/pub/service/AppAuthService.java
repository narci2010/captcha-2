package com.shearf.cloud.apps.captcha.pub.service;

import com.shearf.cloud.apps.captcha.pub.domain.model.AppAuth;
import com.shearf.cloud.apps.commons.foundation.mybatis.IGenericService;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/7
 */
public interface AppAuthService extends IGenericService<AppAuth, Integer> {
    AppAuth getByAppKey(String appKey);
}
