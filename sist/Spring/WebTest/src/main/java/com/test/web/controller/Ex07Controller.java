package com.test.web.controller;


import com.test.web.model.AddressDTO;
import com.test.web.model.SpringDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@Controller
public class Ex07Controller {

    @GetMapping("ex07.do")
    public String ex07(){ // add.do 역할
        
        return "ex07";
    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(HttpServletRequest req){
//
//        try {
//            req.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//
//        String data = req.getParameter("data");
//        req.setAttribute("data", data);
//
//        return "ex07ok";
//    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(@RequestParam("data") String data, Model model){
//
//        //String data = req.getparameter("data")와 같은 코드
//
//        //System.out.println(data);
//
//        model.addAttribute("data", data); // = req.setAttribute
//
//        return "ex07ok";
//    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(@RequestParam("data") String data, Model model) {
//
//        //String req.getParameter("key")
//
//        int num = Integer.parseInt(data);
//
//        model.addAttribute("data",num * 2);
//
//        return "ex07ok";
//    }
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(@RequestParam("data") int data, Model model) {
//
//
//        model.addAttribute("data", data * 3);
//
//        return "ex07ok";
//    }
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(@RequestParam("data") boolean data, Model model) {
//
//        model.addAttribute("data", data ? "참" : "거짓");
//
//        return "ex07ok";
//    }
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(@RequestParam(value = "data", defaultValue = "100") Integer data, Model model) {
//
//        //Integer은 null이 가능하기때문에 에러가 나지 않음
//        //int는 null이 불가능하기때문에 에러
//        //스프링에서 매개변수에서는 참조형(Integer)를 써라 (에러 최소화)
//
//        model.addAttribute("data", data);
//
//        return "ex07ok";
//    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(String data, Model model) {
//
//        //@RequestParam은 생략 가능
//        // 단 defaultValue같은거 쓸려면 써야됨
//
//        model.addAttribute("data", data);
//
//        return "ex07ok";
//    }
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(Model model,
//                         @RequestParam("data") String name,
//                         @RequestParam("age") Integer age,
//                         @RequestParam("address") String address) {
//
//        //DB insert
//        AddressDTO dto = new AddressDTO();
//        dto.setName(name);
//        dto.setAge(age);
//        dto.setAddress(address);
//
//        SpringDAO dao = new SpringDAO();
//        dao.add(dto);
//
//
//        return "ex07ok";
//    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(Model model,
//                         String name,
//                         Integer age,
//                         String address) {
//
//        //DB insert
//        AddressDTO dto = new AddressDTO();
//        dto.setName(name);
//        dto.setAge(age);
//        dto.setAddress(address);
//
//        SpringDAO dao = new SpringDAO();
//        dao.add(dto);
//
//
//        return "ex07ok";
//    }
//
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(Model model, String[] cb) {
//
//        //req.getParameterValues("cb")
//
//        model.addAttribute("cb", Arrays.toString(cb));
//
//
//        return "ex07ok";
//    }

//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(Model model, @RequestParam("cb") List<String> cb) {
//
//        //req.getParameterValues("cb")
//        //컬렉션은 @RequestParam을 생략할 수 없다.
//        model.addAttribute("cb", cb);
//
//
//        return "ex07ok";
//    }
//    @PostMapping("ex07ok.do") // addok.do역할
//    public String ex07ok(Model model, AddressDTO dto, String seq) {
//
//
//        SpringDAO dao = new SpringDAO();
//        dao.add(dto);
//
//        System.out.println(seq);
//
//        return "ex07ok";
//    }
    @PostMapping("ex07ok.do") // addok.do역할
    public String ex07ok(Model model, @ModelAttribute("data") String data) {

        //model.addAttribute("data", data);
        

        return "ex07ok";
}


}
