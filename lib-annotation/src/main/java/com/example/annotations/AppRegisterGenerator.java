package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CHENQIAO on 2017/12/26.
 */
@Target(ElementType.TYPE)//声明注解使用在类上面
@Retention(RetentionPolicy.SOURCE)//编译器在编译源码阶段处理
public @interface AppRegisterGenerator {

    String packageName();

    Class<?> registerTemplete();
}
