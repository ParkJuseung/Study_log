package com.example.jsptest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Random rnd = new Random();
        String[] stat = {"당첨" ,"꽝", "다시 한번 기회를 .."};

        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("""
                <html>
                <head>
                    <meta charset="UTF-8">
                </head>
                <body>
                    <h1>추첨결과<h1>
                </body>
                </html>
                """.formatted(stat[rnd.nextInt(stat.length)]));

        writer.close();
    }

}
