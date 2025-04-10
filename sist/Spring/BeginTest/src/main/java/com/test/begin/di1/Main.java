package com.test.begin.di1;

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
		
		//Hong -> 퇴사
		//Lee  -> 입사
		//Hong의 역할과 Lee의 역할은 동일하다.
		
		
		//Main이 필요해서 만드는게 아니라 Service에 필요해서 만듬 
		Hong hong = new Hong();
		Lee lee = new Lee();
		
		//Service service = new Service(hong); // 의존 주입( DI ) - 생성자
		Service service = new Service();
		service.setHong(hong); // 의존 주입 (DI)
		service.setLee(lee);
		service.use();
		
		
		
	}
}
