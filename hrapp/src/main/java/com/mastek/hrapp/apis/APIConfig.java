package com.mastek.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.services.EmployeeService;

@Component
public class APIConfig extends ResourceConfig {

	public APIConfig() {
		//register each service class to enable services as API
		register(EmployeeService.class);
	}
	
}
