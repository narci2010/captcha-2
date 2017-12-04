package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.shearf.cloud.apps.captcha.pub.dal.mapper.AppAuthMapper;
import com.shearf.cloud.apps.captcha.pub.domain.model.AppAuth;
import com.shearf.cloud.apps.captcha.pub.service.AppAuthService;
import com.shearf.cloud.apps.commons.foundation.mybatis.AbstractGenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/7
 */
@Service
public class AppAuthServiceImpl extends AbstractGenericService<AppAuth, Integer, AppAuthMapper> implements AppAuthService {

    @Resource
    private AppAuthMapper appAuthMapper;

    @Override
    protected AppAuthMapper getMapper() {
        return appAuthMapper;
    }

    @Override
    public AppAuth getByAppKey(String appKey) {
        return getMapper().getByAppKey(appKey);
    }
}
