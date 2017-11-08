package com.shearf.cloud.apps.captcha.pub.config;

import com.shearf.cloud.apps.captcha.pub.domain.bean.ConfigValue;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public ConfigValue configValue() {
        ConfigValue configValue = new ConfigValue();
        configValue.setRequestValidSeconds(resolver.getProperty("request.valid.seconds", Integer.class, 10));
        String[] captchaScanRange = resolver.getProperty("captcha.scan.range", String.class, "1,100000")
                .split(",");
        configValue.setCaptchaScanRangeMin(Integer.valueOf(StringUtils.trim(captchaScanRange[0])));
        configValue.setCaptchaScanRangeMax(Integer.valueOf(StringUtils.trim(captchaScanRange[1])));
        return configValue;
    }
}
