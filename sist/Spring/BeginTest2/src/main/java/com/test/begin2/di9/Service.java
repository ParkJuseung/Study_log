//package com.test.begin2.di9;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Service {
//
//	// 2. 멤버 변수 승격
//	private Hong hong;
//
//	// 3.의존 주입 도구 생성 ( 생성자 or Setter )
//	
//	
//	// 1)의존 주입 도구에 선언  
//	@Autowired
//	public Service(Hong hong) {
//		this.hong = hong;
//	}
//	
//	
//	public void use() {
//
//		// Service < - (의존관계) -> Hong
//		// Servie 객체는 Hong 객체를 의존한다.
//		// - Hong 객체는 Service 객체의 의존객체이다.
//
//		// 1. 직접 생성 x
//		// Hong hong = new Hong();
//		hong.work();
//		
//		
//		//Main > Service > Hong
//		
//		
//	}
//}

//
//
//package com.test.begin2.di9;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Service {
//
//	// 2. 멤버 변수 승격
//	private Hong hong;
//
//	// 3.의존 주입 도구 생성 ( 생성자 or Setter )
//	
//	@Autowired
//	public void setHong(Hong hong) {
//		this.hong = hong;
//	}
//	
//	
//	public void use() {
//
//		hong.work();
//
//	}
//}



//
//package com.test.begin2.di9;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Service {
//
//	@Autowired
//	private Hong hong;
//
//	// 3.의존 주입 도구 생성 ( 생성자 or Setter )
//	
//	public void use() {
//		hong.work();
//	}
//}



package com.test.begin2.di9;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/*
 * @Component public class Service {
 * 
 * 
 * private Hong hong;
 * 
 * //생성자가 1개뿐이라면 별도의 선언없이 의존 주입이 발생 public Service(Hong hong) { this.hong= hong;
 * }
 * 
 * public void use() { hong.work(); } }
 */





//@Component
//public class Service {
//	
//	@Setter(onMethod_ = @Autowired)
//	private Hong hong;
//	
//	public void use() {
//		hong.work();
//	}
//}



// lombok 사용 + 생성자 사용 
@Component
//@NoArgsConstructor // default 생성자 
@AllArgsConstructor // 모든 멤버변수를 인자로 하는 생성자 
//@RequiredArgsConstructor
public class Service {

	private Hong hong;
	
	
//	public Service(Hong hong) {
//		this.hong= hong;
//	}
	
	
	public void use() {
		hong.work();
	}
}