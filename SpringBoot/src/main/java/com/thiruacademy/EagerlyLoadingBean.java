package com.thiruacademy;

import org.springframework.stereotype.Component;

@Component
public class EagerlyLoadingBean {
	public EagerlyLoadingBean() {
		System.out.println("EagerlyLoadingBean object created");
	}
}
