package com.shearf.cloud.apps.captcha.pub.web.interceptor;

import com.shearf.cloud.apps.captcha.pub.service.SecurityService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
public class SecurityInterceptor implements HandlerInterceptor {

    public SecurityInterceptor(SecurityService securityService) {
        this.securityService = securityService;
    }

    private final SecurityService securityService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String sign = httpServletRequest.getParameter("sign");
        String time = httpServletRequest.getParameter("time");
        String appKey = httpServletRequest.getParameter("app_key");

        if (StringUtils.isNotBlank(sign) && StringUtils.isNotBlank(time) && StringUtils.isNotBlank(appKey)) {
            return securityService.requestValid(appKey, sign, DateTime.parse(time, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate());
        } else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
