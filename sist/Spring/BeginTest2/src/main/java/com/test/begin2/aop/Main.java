package com.test.begin2.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
//		
//		//메모장 구현
//		Memo memo = new MemoImpl();
//		
//		//글쓰기
//		memo.add("메모장입니다.");
//		
//		//읽기
//		try {
//			String content = memo.read("1");
//			System.out.println(content);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//수정
//		System.out.println(memo.edit("2",  "수정된 메모"));
//		
//		//삭제
//		System.out.println(memo.del("3"));
//		
//		Logger logger = new Logger();
//		Memo memo = new MemoImpl();
//		
//		memo.add("메모장입니다.");
//		logger.log();
//		
//		try {
//			String content = memo.read("1");
//			System.out.println(content);
//			logger.log();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(memo.edit("2",  "수정된 메모"));
//		logger.log();
//		
//		System.out.println(memo.del("3"));
//		logger.log();
		
		
		
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin2/aop/memo.xml");
		Memo memo = (Memo)context.getBean("memo");
		
		//메모장 구현
		
		//Memo memo = new MemoImpl();
		
		//글쓰기
		memo.add("메모장입니다.");
		
		//읽기
		try {
			String content = memo.read("1");
			System.out.println(memo.read("100"));
			System.out.println(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//수정
		System.out.println(memo.edit("2",  "수정된 메모"));
		
		//삭제
		System.out.println(memo.del("3"));
		
		
	}
}
