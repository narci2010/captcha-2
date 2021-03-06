package com.shearf.cloud.apps.captcha.pub.dal.mapper;

import com.shearf.cloud.apps.captcha.pub.domain.model.SimpleCaptcha;
import com.shearf.cloud.apps.commons.foundation.mybatis.IGenericMapper;
import org.springframework.stereotype.Repository;

/**
 * @author xiahaihu2009@gmail.com
 */
@Repository
public interface SimpleCaptchaMapper extends IGenericMapper<SimpleCaptcha, Integer> {

}
