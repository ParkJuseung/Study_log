package com.test.java.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml") // 내가 부를 빈이 있어서 가져오는건데 내가 필요한건 servlet-context.xml이 필요함
public class TestServiceTests {
	@Autowired
	private TestService testService;
	
	
	@Test
	public void testWork() {
		
		assertNotNull(testService);
		
		String data = "홍길동";
		
		assertEquals(data.length(), testService.work(data));
	}
	
}
