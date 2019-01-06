package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 自定义负载均衡算法
 */
@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		return new RoundRubinRule5_fn();
	}
}
