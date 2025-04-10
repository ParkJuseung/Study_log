package com.test.web.controller;

import com.test.web.model.SpringDAO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//스프링 빈이 되기위한 작업
//1. <bean>태그로 선언
//2. 어노테이션 사용
//  - @Component
//  - @Controller > 스프링 빈 + 컨트롤러 역할
//  - @Service    > 스프링 빈 + 서비스 역할
//  - @Repository > 스프링 빈 + 저장소 역할(DAO)

@Service
@Controller
@RequiredArgsConstructor //
public class Ex09Controller {

    //필드 주입
//    @Autowired
//    private SpringDAO dao;


    //(권장 방식)
    private final SpringDAO dao; // final : 선언과 동시에 초기화

    //@NonNull
    //private SpringDAO dao;



    //생성자 주입
    //@Autowired 생성자가 1개일때는 없어도 됨
//    public Ex09Controller(SpringDAO dao) {
//        this.dao = dao;
//    } -> 롬복이 생성함

    @GetMapping("/ex09.do")
    public String ex09(Model model){

        //SpringDAO dao = new SpringDAO();
        int count = dao.count();

        model.addAttribute("count", count);

        return "ex09";
    }
}
