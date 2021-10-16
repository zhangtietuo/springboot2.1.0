package com.ztt.mybatis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangtietuo
 * @Description: spring提供的后置器，可以修改beanDefinition属性
 * @Date: 2019/3/14 15:37
 */
@Component
public class ZttBeanFactoryPostProcesser implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBeanDefinition("userRepository").getBeanClassName());
    }
}
