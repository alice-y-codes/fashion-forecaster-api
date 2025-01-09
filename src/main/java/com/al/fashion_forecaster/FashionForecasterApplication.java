package com.al.fashion_forecaster;

import com.al.fashion_forecaster.config.TwitterApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TwitterApiConfig.class)
public class FashionForecasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionForecasterApplication.class, args);
	}

}
