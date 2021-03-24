package com.atguigu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {



    /**
     * 把请求参数的map，都封装注入到Bean对象中<br/>
     */
    public static <T> T copyParamToBean(Map source,T target){
        try {
            /**
             * 参数的格式是：name=value&name=value <br/>
             * 把map中的数据，一次性注入到Bean对象中<br/>
             */
            System.out.println("注入参数前:" + target);
            BeanUtils.populate(target,source);
            System.out.println("注入参数后:" + target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }



}
