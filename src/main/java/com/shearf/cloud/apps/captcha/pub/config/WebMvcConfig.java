package com.shearf.cloud.apps.captcha.pub.config;

import com.shearf.cloud.apps.captcha.pub.service.SecurityService;
import com.shearf.cloud.apps.captcha.pub.web.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
@Configuration
@ComponentScan("com.shearf.cloud.apps.captcha.pub.web")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private SecurityService securityService;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new SecurityInterceptor(securityService));
        registration.addPathPatterns("/captcha/**");
    }


}
