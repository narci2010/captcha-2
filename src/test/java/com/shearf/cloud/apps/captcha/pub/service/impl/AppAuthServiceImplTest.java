package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.shearf.cloud.apps.captcha.pub.domain.model.AppAuth;
import com.shearf.cloud.apps.captcha.pub.service.AppAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AppAuthServiceImplTest {

    @Resource
    private AppAuthService appAuthService;

    @Test
    public void insertTest() {
        AppAuth appAuth = new AppAuth();
        appAuth.setAppId(1);
        appAuth.setAppKey(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        appAuth.setAppSecret(UUID.randomUUID().toString().trim().replaceAll("-", ""));
        appAuth.setExpireTime(new Date());
        appAuth.setCreateTime(new Date());
        appAuth.setUpdateTime(new Date());
        appAuth.setStatus(AppAuth.Status.ENABLED.getCode());
        appAuthService.insert(appAuth);
    }

}