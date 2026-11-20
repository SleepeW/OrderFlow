package com.example.OrderFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFlowApplication.class, args);
	}

}
