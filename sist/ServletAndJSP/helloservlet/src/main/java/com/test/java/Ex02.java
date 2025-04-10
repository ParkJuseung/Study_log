package com.test.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class Ex02 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();
        Random rnd = new Random();
        int dan = rnd.nextInt(8) + 2;


        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset='UTF-8'>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>구구단</h1>");
        for(int i = 1; i<=9; i++){
            writer.write(String.format("<div>%d x %d = %d</div>",dan, i ,dan*i));
        }
        writer.write("</body>");
        writer.write("</html>");

        writer.close();
    }

}
