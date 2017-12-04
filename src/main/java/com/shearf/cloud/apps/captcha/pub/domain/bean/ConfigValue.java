package com.shearf.cloud.apps.captcha.pub.domain.bean;

import lombok.Data;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
@Data
public class ConfigValue {

    /**
     * 发起请求有效时间
     */
    private int requestValidSeconds;

    /**
     * 验证码随机分配范围开始最小值
     */
    private int captchaScanRangeMin;

    /**
     * 验证码随机分配范围最大值
     */
    private int captchaScanRangeMax;
}
