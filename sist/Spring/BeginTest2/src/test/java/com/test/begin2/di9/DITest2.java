package com.test.begin2.di9;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트용 자바 클래스 (JUnit) -> 단위 테스트 도구 

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 스프링이 읽음 -> 빈의 존재를 알게됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml") // 스프링이 읽음 -> 빈의 존재를 알게됨
public class DITest2 {
	
	@Autowired
	private Hong hong;
	
	@Test
	public void testExist() {
		assertNotNull(hong);
	}
}
