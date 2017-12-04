package com.shearf.cloud.apps.captcha.pub.service.impl;

import com.github.pagehelper.PageHelper;
import com.shearf.cloud.apps.captcha.pub.common.Constant;
import com.shearf.cloud.apps.captcha.pub.dal.param.SimpleCaptchaQueryParam;
import com.shearf.cloud.apps.captcha.pub.domain.bean.ConfigValue;
import com.shearf.cloud.apps.captcha.pub.domain.entity.CaptchaAndImg;
import com.shearf.cloud.apps.captcha.pub.domain.model.SimpleCaptcha;
import com.shearf.cloud.apps.captcha.pub.service.CaptchaService;
import com.shearf.cloud.apps.captcha.pub.service.SimpleCaptchaService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author xiahaihu2009@gmail.com
 * @date 2017/11/8
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ConfigValue configValue;

    @Resource
    private SimpleCaptchaService simpleCaptchaService;

    @Override
    public CaptchaAndImg getCaptcha() {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        int id = new Random().nextInt(configValue.getCaptchaScanRangeMax() - configValue.getCaptchaScanRangeMin() + 1)
                + configValue.getCaptchaScanRangeMin();
        String key = Constant.SAMPLE_CAPTCHA_PREFIX + String.valueOf(id);
        String captchaStorage = valueOperations.get(key);
        // 存在缓存则用缓存
        if (captchaStorage != null) {
            String[] captchaInfo = captchaStorage.split("_");
            try {
                CaptchaAndImg captchaAndImg = new CaptchaAndImg();
                captchaAndImg.setImgUrl(captchaInfo[1]);
                captchaAndImg.setCaptcha(captchaInfo[0]);
                return captchaAndImg;
            } catch (ArrayIndexOutOfBoundsException e) {
                LOGGER.error("分割缓存的内容失败, 缓存key:{}, value:{}", key, captchaStorage);
            }
        } else {
            // 读取数据库数据
            PageHelper.startPage(id, 1, false);
            SimpleCaptchaQueryParam param = new SimpleCaptchaQueryParam();
            DateTime startDateTime = new DateTime().withTimeAtStartOfDay();
            DateTime endDateTime = startDateTime.plusDays(1);
            param.setStartTime(startDateTime.toDate());
            param.setEndTime(endDateTime.toDate());
            List<SimpleCaptcha> list = simpleCaptchaService.queryByParam(param);
            if (list != null && list.size() > 0) {
                SimpleCaptcha simpleCaptcha = list.get(0);
                if (simpleCaptcha != null) {
                    CaptchaAndImg captchaAndImg = new CaptchaAndImg();
                    captchaAndImg.setCaptcha(simpleCaptcha.getCode());
                    captchaAndImg.setImgUrl(simpleCaptcha.getImgUrl());

                    // 设置缓存
                    valueOperations.set(key, captchaAndImg.getCaptcha() + "_" + simpleCaptcha.getImgUrl(),
                            48, TimeUnit.HOURS);

                    return captchaAndImg;
                }
            } else {
                LOGGER.error("获取数据库中的数据失败, 数据不存在, 查询条件:{}, offset:{}, limit:{}", param, id, 1);
            }
        }
        return null;
    }
}
