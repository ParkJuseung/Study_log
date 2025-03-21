package com.test.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Ex03_Receive extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // 결과 페이지 생성 -> 반환
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("""
                <html>
                        <head>
                            <meta charset="UTF-8">
                        </head>
                        <body>
                            <h1>보내기</h1>
                            <form method="GET" action="/servlet/ex03_receive.do">
                            <table border="1" width="300">
                                <tr>
                                    <th>이름</th>
                                    <td><input type="text" name="name" size="10"></td>
                                </tr>
                                <tr>
                                    <th>나이</th>
                                    <td><input type="number" name="age" size="10"></td>
                                </tr>
                                </table>
                                <div>
                                    <button>보내기</button>
                                </div>
                            </form>
                        </body>
                        </html>

                """);
        writer.close();
    }
}
