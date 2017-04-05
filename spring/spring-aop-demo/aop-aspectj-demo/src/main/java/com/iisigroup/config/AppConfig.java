package com.iisigroup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.iisigroup")
@EnableAspectJAutoProxy
public class AppConfig {
}
