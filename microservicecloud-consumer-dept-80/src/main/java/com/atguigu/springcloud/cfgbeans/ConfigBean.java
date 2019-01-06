package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	
	/**
	 * 访问者通过RestTemplate访问服务，重新构建RestTemplate时候加上负载均衡
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*@Bean
	public IRule myRule() {
		return new RandomRule();// 修改负载均衡算法为随机，默认是RoundRobinRule轮循
	}*/
}
