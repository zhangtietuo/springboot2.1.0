package com.ztt;

import com.ztt.domain.PersonInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})  //因为创建项目时候添加了数据库组件，所以autoconfig会去读取数据源配置，而新建的项目还没有配置数据源，所以会导致异常出现
public class Springboot2Application {

	private final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot2Application.class, args);
		PersonInfo personInfo = Binder.get(context.getEnvironment()).bind("my.property", Bindable.of(PersonInfo.class)).orElseThrow(IllegalStateException::new);
	}
}
