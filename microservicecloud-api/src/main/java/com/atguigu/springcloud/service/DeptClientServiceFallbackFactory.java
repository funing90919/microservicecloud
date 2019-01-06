package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("Consumer客户端提供的服务降级信息，该服务Provider暂时关闭").setDb_source("no db selected");
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
