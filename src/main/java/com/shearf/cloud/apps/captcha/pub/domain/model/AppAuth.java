package com.shearf.cloud.apps.captcha.pub.domain.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.shearf.cloud.apps.commons.foundation.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

/**
 * @author xiahaihu2009@gmail.com
 */
@Data
public class AppAuth extends BaseModel {

    private static final long serialVersionUID = -5515362792209602685L;

    /**
     * ID
     */
    private Integer id;

    /**
     * app ID
     */
    private Integer appId;

    /**
     * app key
     */
    private String appKey;

    /**
     * app 密码
     */
    private String appSecret;

    /**
     * 状态（1：启用，0：禁用）
     */
    private Integer status;

    /**
     * 过期时间
     */
    private Date expireTime;

    @AllArgsConstructor
    public enum Status {

        /**
         * 启用
         */
        ENABLED(1, "启用"),
        /**
         * 禁用
         */
        DISABLED(0, "禁用"),

        ;

        @Getter
        private int code;

        @Getter
        private String name;

        private static Map<Integer, Status> map;

        static {
            map = Maps.newHashMap();
            for (Status status : Status.values()) {
                if (!map.containsKey(status.getCode())) {
                    map.put(status.getCode(), status);
                }
            }
        }

        public static Status getStatus(int code) {
            Preconditions.checkArgument(Status.map.containsKey(code), "不存在相应code对应的状态");
            return Status.map.get(code);
        }

        public static String getStatusName(int code) {
            Preconditions.checkArgument(Status.map.containsKey(code), "不存在相应code对应的状态");
            return Status.map.get(code).getName();
        }

    }

}
