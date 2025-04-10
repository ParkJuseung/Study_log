package com.test.begin.di2;

public class Main {
	public static void main(String[] args) {
		
		//의존 관계
		//Main -> (의존) -> Service -> (의존) -> Hong
		//Service 객체는 Main의 의존 객체이다.
		//Hong 객체는 Service의 의존 객체이다. 
		
		//***여태까지의 방식
		// - 필요로 하는 의존 객체를 직접 생성 + 사용했다. 
		
		
		//main -> service -> hong
		//사장 -  팀장  -  직원
		
		//Main이 필요해서 만드는게 아니라 Service에 필요해서 만듬 
		//Hong hong = new Hong();
		Employee employee = new Lee();
		
		
		//Service service = new Service(hong); // 의존 주입( DI ) - 생성자
		Service service = new Service();
		service.setEmployee(employee); // 의존 주입 (DI)
		service.use();
		
		
		
	}
}
