package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${eureka.client.server-url.defaultZone}")
	private String eurekaServers;
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig() {
		System.err.println(port);
		return "applicationName:" + applicationName + "eurekaServers:" + eurekaServers + "port:" + port;
	}
}
