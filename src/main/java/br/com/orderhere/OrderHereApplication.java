package br.com.orderhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OrderHereApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderHereApplication.class, args);
	}

}
