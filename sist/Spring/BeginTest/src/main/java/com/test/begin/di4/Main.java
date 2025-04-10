package com.test.begin.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/begin/di4/di4.xml");
		
//		Hong hong = (Hong)context.getBean("hong");
//		
//		Service service = (Service)context.getBean("service");
//		
//		service.setEmployee(hong); // 의존 주입
//		
//		service.use(); 

		

		
		Service service = (Service)context.getBean("service");
		
		service.use(); 
	}
}
