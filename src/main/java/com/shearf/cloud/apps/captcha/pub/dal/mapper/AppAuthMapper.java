package com.shearf.cloud.apps.captcha.pub.dal.mapper;

import com.shearf.cloud.apps.captcha.pub.domain.model.AppAuth;
import com.shearf.cloud.apps.commons.foundation.mybatis.IGenericMapper;
import org.springframework.stereotype.Repository;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/7
 */
@Repository
public interface AppAuthMapper extends IGenericMapper<AppAuth, Integer> {
    AppAuth getByAppKey(String appKey);
}
