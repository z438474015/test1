package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.IUserServiceImpl;

public class test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserServiceImpl i = (IUserServiceImpl) ac.getBean("IUserServiceImpl");
	}
}
