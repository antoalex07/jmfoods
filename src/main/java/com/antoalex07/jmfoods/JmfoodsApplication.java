package com.antoalex07.jmfoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JmfoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmfoodsApplication.class, args);
	}

}
