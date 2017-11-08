package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.shearf.cloud.apps.captcha.pub.dal.mapper.SimpleCaptchaMapper;
import com.shearf.cloud.apps.captcha.pub.domain.model.SimpleCaptcha;
import com.shearf.cloud.apps.captcha.pub.service.SimpleCaptchaService;
import com.shearf.cloud.apps.commons.foundation.mybatis.AbstractGenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
@Service
public class SimpleCaptchaServiceImpl extends AbstractGenericService<SimpleCaptcha, Integer, SimpleCaptchaMapper> implements SimpleCaptchaService {

    @Resource
    private SimpleCaptchaMapper simpleCaptchaMapper;

    @Override
    protected SimpleCaptchaMapper getMapper() {
        return simpleCaptchaMapper;
    }
}
