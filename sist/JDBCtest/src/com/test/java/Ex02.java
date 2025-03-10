package com.test.java;

import java.sql.Connection;

public class Ex02 {
    public static void main(String[] args) {

        // 접속시 발생하는 에러

        Connection conn = null;
        DBUtil util = new DBUtil();

        conn = util.open("localhost", "server", "java1234");


        try {

            System.out.println(conn.isClosed());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
