package com.test.java;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Hello extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //업무 코드 작성
        // DB 작업 -> Select
        String name = "홍길동";

        req.setAttribute("name", name);

        //resp.sendRedirect("/mvc/hello.jsp");
        //pageContext.forward("/mvc/hello.jsp");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(req, resp);
    }
}