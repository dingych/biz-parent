package com.waynechu.renting.test.aop.jdk;

import cn.waynechu.spirngcloud.common.annotation.MethodLogAnnotation;

/**
 * @author zhuwei
 * @date 2018/11/7 10:59
 */
public interface Sub {

    @MethodLogAnnotation
    String printOne(String str);
}