package com.test.begin.di2;

public class Service {
	
	private Employee employee;
	
	
	
	
	//1. 의존 객체를 주입받는다. ( 생성자 주입)
//	public Service(Hong hong) {
//		this.hong = hong;
//		
//	}
	// 2. setter 주입 
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	public void use() {
		//본인 업무 구현 
		
		
		
		// 일부 업무 -> 위임(hong)
		//***여태까지의 방식
		// - 필요로 하는 의존 객체를 직접 생성 + 사용했다.
		//***앞으로의 방식
		// - 의존객체를 만들지 않음 (다른사람이 만듬) 
		
		//Hong hong = new Hong();
		employee.work();
		
		
		// 본인 업무 구현 
		
		
	}
}
