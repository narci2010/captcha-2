package com.shearf.cloud.apps.captcha.pub.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

/**
 * @author xiahaihu2009@gmail.com
 */
@Configuration
@MapperScan(basePackages = "com.shearf.cloud.apps.captcha.pub.dal.mapper", annotationClass = Repository.class)
public class AppContextConfig implements EnvironmentAware {

    private RelaxedPropertyResolver resolver;

    @Override
    public void setEnvironment(Environment environment) {
        resolver = new RelaxedPropertyResolver(environment, "app.");
    }
}
