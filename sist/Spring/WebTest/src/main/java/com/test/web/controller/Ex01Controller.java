package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//서블릿 역할
public class Ex01Controller implements Controller{

	
	//요청 메서드 (DoGet / DoPost 역할)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//servlet
		//RequestDispatcher -> forward()
		
		//ModelAndView
		//1. Model -> 데이터 전송
		//2. View  -> JSP
		
		String name = "홍길동";
		
//		request.setAttribute("name", name);
		
		
		
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("/WEB-INF/views/ex01.jsp"); // bean이 없으면 이걸 사용 
		mv.setViewName("ex01"); // ViewResolver 실행 => "/WEB-INF/views/" + "ex01" + ".jsp"
		
		mv.addObject("name", name); // 권장 방식 
		
		return mv;
	}
	
}
