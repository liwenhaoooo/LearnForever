package com.online_course.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.online_course")
@MapperScan("com.online_course.server.mapper")
public class BusinessApplication {
	private static final Logger LOG = LoggerFactory.getLogger(BusinessApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BusinessApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("Business地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}
}
