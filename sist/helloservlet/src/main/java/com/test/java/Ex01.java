package com.test.java;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        //구구단 중 랜덤으로 하나 출력 -> 웹 페이지로
        try {
            Random rnd = new Random();
            int dan = rnd.nextInt(8) + 2;
            File file = new File(".");
            FileWriter writer = new FileWriter(".\\src\\main\\webapp\\ex01.html");

            writer.write("<html>");
            writer.write("<head>");
            writer.write("<meta charset='UTF-8'>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1>Hello Servlet</h1>");
            for(int i = 1; i<=9; i++){
                writer.write(String.format("<div>5 x 1 = 5</div>",dan, i ,dan*i));
            }
            writer.write("</body>");
            writer.write("</html>");

            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
