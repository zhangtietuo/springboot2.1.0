1.springboot2.1.0 milestone版本（里程碑）
2 引入spring framework5.0.0(Web Flux和 Kotlin), 必须依赖java8, 模块化工具(maven gradle等)   开发 IO 密集型服务的时候，选择 WebFlux 去实现
3.新特性：Web Flux 的函数式编程（Lambda）
        响应编程(Reactive Streams)
        异步编程Servlet3.1或Asyc NIO
4.maven命令行方式创建项目mvn archetype:generate -DinteractiveMode=false -DgroupId=com.ztt -DartifactId=first-app-by-maven -Dversion=1.0.0-SNAPSHOT
5.把springboot应用由单模块变成多模块应用
6.启动项目：java -jar web-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --server.port=8888
7.Relaxed Binding 2.0
8. Hikari连接池
9.ApplicationStartingEvent
  ApplicationEnvironmentPreparedEvent
  ApplicationPreparedEvent
  ApplicationStartedEvent <= 新增的事件
  ApplicationReadyEvent
  ApplicationFailedEvent

10.热部署 spring-boot-devtools  https://blog.csdn.net/aqsunkai/article/details/69663159

11. 在配置服务时的VMoptions中添加启动的端口: -Dserver.port=8082