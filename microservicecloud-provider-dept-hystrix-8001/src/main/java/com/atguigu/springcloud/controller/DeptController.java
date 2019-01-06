package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@RequestMapping(value = { "/dept/get/{id}" }, method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get") // 方法失败并抛出异常后，调用fallbackMethod指定方法
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID：" + id + "没有记录");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有记录 @HystrixCommand").setDb_source("no this database");
	}
}
