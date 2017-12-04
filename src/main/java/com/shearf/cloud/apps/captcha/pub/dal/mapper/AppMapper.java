package com.shearf.cloud.apps.captcha.pub.dal.mapper;

import com.shearf.cloud.apps.captcha.pub.domain.model.App;
import com.shearf.cloud.apps.commons.foundation.mybatis.IGenericMapper;
import org.springframework.stereotype.Repository;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/7
 */
@Repository
public interface AppMapper extends IGenericMapper<App, Integer> {
}
