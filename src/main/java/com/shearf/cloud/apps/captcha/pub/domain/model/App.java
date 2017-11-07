package com.shearf.cloud.apps.captcha.pub.domain.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.shearf.cloud.apps.commons.foundation.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

/**
 * @author xiahaihu2009@gmail.com
 * @Date 2017/11/7
 */
@Data
public class App extends BaseModel {

    private static final long serialVersionUID = -5382743840086591804L;
    /**
     * ID
     */
    private Integer id;

    /**
     * APP名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 拥有者类型（1：个人，2：公司）
     */
    private String ownerType;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 联系人email地址
     */
    private String contactEmail;

    /**
     * app描述
     */
    private String description;

    @AllArgsConstructor
    public enum OwnerType {
        PERSONAL(1, "个人"),
        COMPANY(2, "公司")
        ;

        @Getter
        private int code;
        @Getter
        private String name;

        private static Map<Integer, OwnerType> map;

        static {
            map = Maps.newHashMap();
            for (OwnerType ownerType : OwnerType.values()) {
                if (!map.containsKey(ownerType.getCode())) {
                    map.put(ownerType.getCode(), ownerType);
                }
            }
        }

        public static OwnerType getOwnerType(int code) {
            Preconditions.checkArgument(map.containsKey(code), "不存在相应code对应的OwnerType");
            return map.get(code);
        }

        public static String getOwnerTypeName(int code) {
            Preconditions.checkArgument(map.containsKey(code), "不存在相应code对应的OwnerType");
            return map.get(code).getName();
        }
    }

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
