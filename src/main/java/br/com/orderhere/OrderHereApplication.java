package br.com.orderhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.orderhere")
@EntityScan(basePackages = "br.com.orderhere.domain")
public class OrderHereApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderHereApplication.class, args);
	}

}
