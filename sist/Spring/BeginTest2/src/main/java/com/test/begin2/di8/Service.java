package com.test.begin2.di8;

public class Service {

	// 2. 멤버 변수 승격
	private Hong hong;

	// 3.의존 주입 도구 생성 ( 생성자 or Setter )
	public Service(Hong hong) {
		this.hong = hong;
	}

	public void use() {

		// Service < - (의존관계) -> Hong
		// Servie 객체는 Hong 객체를 의존한다.
		// - Hong 객체는 Service 객체의 의존객체이다.

		// 1. 직접 생성 x
		// Hong hong = new Hong();
		hong.work();
		
		
		//Main > Service > Hong
		
		
	}
}
