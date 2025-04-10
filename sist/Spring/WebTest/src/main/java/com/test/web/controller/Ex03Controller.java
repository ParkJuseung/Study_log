package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//public class Ex03Controller implements Controller {
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return null;
//    }
//}


@Controller
@RequestMapping("/ex03")
public class Ex03Controller{

    //요청 메서드 > 누가 호출?  (톰캣, 스프링 컨테이너)
    //요청 메서드 > 맘대로 구현

    //doGet/ doPost / handleRequest
    //많은 메서드 중에 얘가 HTMl Mapping 역할
    @RequestMapping
    public String test(HttpServletRequest req){
        System.out.println("컨트롤러 요청이 발생했습니다.");

        req.setAttribute("name", "홍길동");


        //ViewResolver 호출(servlet-context.xml)
        return "ex03"; // JSP 호출
    }

    public void aaa(){

    }

    public void bbb(){

    }
}





















