package com.thiruacademy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DBConfig {
	
	
	@Value("${server.port}")
	private String port;
	@Value("${server.name}")
	private String name;
	
	@Profile("dev")
	public String config() {
		System.out.println("Port and name Values in DBConfig :: "+port+" "+name);
		return "Values displayed";
	}
}
