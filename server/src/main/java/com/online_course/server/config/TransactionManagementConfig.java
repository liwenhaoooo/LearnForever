package com.online_course.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wenhaoli
 * @date 2022/06/02 20:07
 */

@EnableTransactionManagement
@Configuration
public class TransactionManagementConfig {
    //SpringBoot默认开启事务，不需要在添加事务配hi，不需要增加TransactionManagementConfig类，
        //也不需要再启动类添加 @EnableTransactionManagement 注解
}
