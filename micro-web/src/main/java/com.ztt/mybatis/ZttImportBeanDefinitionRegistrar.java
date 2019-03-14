package com.ztt.mybatis;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/3/14 15:52
 */
public class ZttImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //扫描@zttScan里的包名
        //System.out.println(beanDefinitionRegistry.getBeanDefinition("userRepository"));
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ZttFactoryBean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.ztt.repository.UserRepositoryInter");
        beanDefinitionRegistry.registerBeanDefinition(beanDefinition.getBeanClass().getSimpleName(), beanDefinition);
    }
}
