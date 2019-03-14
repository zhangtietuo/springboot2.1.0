package com.ztt;

import com.ztt.config.AppConfig;
import com.ztt.mybatis.ZttScan;
import com.ztt.service.UserService;
import com.ztt.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
@MapperScan("com.ztt.mapper")
@ZttScan("")
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})  //因为创建项目时候添加了数据库组件，所以autoconfig会去读取数据源配置，而新建的项目还没有配置数据源，所以会导致异常出现
public class Springboot2Application {

	private final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ztt");
		//ApplicationContext context = SpringApplication.run(Springboot2Application.class, args);
		UserService userService = context.getBean(UserServiceImpl.class);
		userService.save("ztt");
		//PersonInfo personInfo = Binder.get(context.getEnvironment()).bind("my.property", Bindable.of(PersonInfo.class)).orElseThrow(IllegalStateException::new);
	}
}
