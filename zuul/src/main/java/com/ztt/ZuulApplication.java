package com.ztt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@EnableEurekaClient
@EnableDiscoveryClient
//@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r ->
//                        r.path("/web/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8081/")).build();
//    }
}
