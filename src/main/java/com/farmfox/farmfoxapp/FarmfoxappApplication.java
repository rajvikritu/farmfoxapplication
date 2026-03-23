package com.farmfox.farmfoxapp;

import com.farmfox.farmfoxapp.configuration.AwsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class FarmfoxappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmfoxappApplication.class, args);
	}

}
