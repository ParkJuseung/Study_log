package com.test.begin.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	
		//스프링 설정 방식
		// 1. XML 방식
		// 2. 어노테이션 방식
		// 3. 자바 방식
		
		
		// 객체 생성 -> 스프링에게 부탁 
		// (old한 버전)
		// 1. XML -> bean 정의 (선언)
		// 2. 스프링 컨테이너 생성
		
		//Hong hong= new Hong();
		
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("/src/main/java/com/text/di3/di3.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/begin/di3/di3.xml");
		
		//빈을 얻어온다. -> 객체를 생성해서 반환해주세요.
		Hong hong = (Hong)context.getBean("hong");
		Lee lee = (Lee)context.getBean("lee");
			
		hong.work();
		lee.work();
		
		Hong hong2 = (Hong)context.getBean("hong");
		hong2.work();
		
		System.out.println(hong.hashCode());
		System.out.println(hong2.hashCode());
	}
}
