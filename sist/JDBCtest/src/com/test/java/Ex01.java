package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(Connection.class);

        System.out.println("데이터베이스 접속");

        Connection conn = null;

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String id = "server";
        String pw = "java1234";

        //JDBC 작업(외부 입출력) -> 예외처리 반드시 해야함
        try {
            //jdbc 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //DB 연결
            conn = DriverManager.getConnection(url, id, pw);

            //현재 오라클 접속 상태(false)
            System.out.println(conn.isClosed());

            //업무 진행(SQL)
            System.out.println("업무진행");

            //접속 종료
            conn.close();

            //현재 오라클 접속 상태(true)
            System.out.println(conn.isClosed());

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }
}
