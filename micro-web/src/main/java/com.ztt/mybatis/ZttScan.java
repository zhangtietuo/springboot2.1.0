package com.ztt.mybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/3/14 16:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(ZttImportBeanDefinitionRegistrar.class)
public @interface ZttScan {

    String[] value() default {};
}
