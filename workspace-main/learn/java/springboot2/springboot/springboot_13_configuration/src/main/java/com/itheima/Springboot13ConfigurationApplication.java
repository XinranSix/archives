package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot13ConfigurationApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
		ServerConfig bean = ctx.getBean(ServerConfig.class);
		System.out.println(bean);

		DruidDataSource bean1 = ctx.getBean(DruidDataSource.class);
		System.out.println(bean1.getDriverClassName());
	}

}
