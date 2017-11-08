package com.shearf.cloud.apps.captcha.pub.web.controller;

import com.shearf.cloud.apps.captcha.pub.domain.bean.ConfigValue;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CaptchaControllerTest {

    @Resource
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Resource
    private ConfigValue configValue;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        configValue.setRequestValidSeconds(100);
    }

    @Test
    public void captchaApiTest() throws Exception {

        String appKey = "17d77ad43dce4b31a2b8513d57ae8a87";
        String appSecret = "e06065627f184ebbbccf449a844e165f";
        DateTime dateTime = new DateTime();
        String time = dateTime.toString("yyyy-MM-dd HH:mm:ss");
        Date timeNow = DateTime.parse(time, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
        String sign = DigestUtils.sha1Hex(appKey + timeNow.getTime() + appSecret);
        String api = "/captcha/v1?app_key=" + appKey + "&time=" + time + "&sign=" + sign;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(api)).andReturn();
        String content = result.getResponse().getContentAsString();
    }
}