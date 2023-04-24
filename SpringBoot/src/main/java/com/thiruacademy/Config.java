package com.thiruacademy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="server")
@Data
@Component
public class Config {
	private String port;
	private String name;
}
