package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = { "/dept/add/" }, method = RequestMethod.POST)
	public boolean add(Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = { "/dept/get/{id}" }, method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = { "/dept/list" }, method = RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}
	
	@RequestMapping(value = { "/dept/discovery" }, method = RequestMethod.GET)
	public Object discovery(){
		List<String> list = client.getServices();
		System.err.println("***********************************************************" + list);
		List<ServiceInstance> serviceList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance serviceInstance : serviceList) {
			System.err.print(serviceInstance.getServiceId());
			System.err.print(serviceInstance.getHost());
			System.err.print(serviceInstance.getPort());
			System.err.print(serviceInstance.getUri());
		}
		return this.client;
	}

}
