package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.shearf.cloud.apps.captcha.pub.dal.mapper.AppMapper;
import com.shearf.cloud.apps.captcha.pub.domain.model.App;
import com.shearf.cloud.apps.captcha.pub.service.AppService;
import com.shearf.cloud.apps.commons.foundation.mybatis.AbstractGenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/7
 */
@Service
public class AppServiceImpl extends AbstractGenericService<App, Integer, AppMapper> implements AppService {

    @Resource
    private AppMapper appMapper;

    @Override
    protected AppMapper getMapper() {
        return appMapper;
    }
}
