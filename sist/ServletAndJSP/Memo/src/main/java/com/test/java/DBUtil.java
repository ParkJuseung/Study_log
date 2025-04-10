package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection open(String server, String id, String pw){
        Connection conn = null;
        String url = "jdbc:oracle:thin:@" + server + ":1521:XE";

        try {
            //jdbc 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //DB 연결
            conn = DriverManager.getConnection(url, id, pw);

            //SQL을 실행하기 전에
            //트랜잭션을 수동으로 제어
//            conn.setAutoCommit(false);



            return conn;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
