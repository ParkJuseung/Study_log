package com.test.java.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDAOTests {
	
	private static TestDAO dao;
	
	@BeforeClass // 테스트 전에 실행되는 메서드 
	public static void begin() {
		dao = new TestDAO();
		System.out.println("begin");
	}
	
	
	//각 테스트를 실행하고 난 후에 실행해라
	@After
	public void end() {
		System.out.println("end");
	}
	
	
	//테스트용 메서드명 -> test + 이름()
	//@Ignore // 진행하고 싶지 않은 테스트에 붙이는 어노테이션 
	@Test
	public void testDAO() {
		//System.out.println(111); // -> 개발자 디버깅용
		//assertArrayEquals(null,  null, null); //-> 테스트 평가
		
		//TestDAO dao = new TestDAO();
		String name = dao.getInsa("1");
		
		//System.out.println(name); // 평가 x
		assertEquals("홍길동", name); // 기대치 , 넣은 값 
		
		System.out.println(111);
	}
	
	@Test
	public void testDAO2() {
		//TestDAO dao = new TestDAO();
		
		String name = dao.getInsa("2");
		
		assertNotEquals("이순신", name);
		
		System.out.println(222);
	}
	
	//assertEquals ( 기대값 , 실제값 ) : 값이 같은지?
	//assertNotEquals(반기대값, 실제값 ): 값이 다른지?
	//

}
