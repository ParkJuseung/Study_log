package com.test.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex05_PreparedStatement {
    public static void main(String[] args) {
        //insert
        String name = "하마";
        int age = 30;
        String gender = "m";
        String tel = "010";
        String address = "서울시";

        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        PreparedStatement pstat = null;

        try {
            conn = util.open("localhost" , "server", "java1234");

            String sql = "insert into tblAddress(seq, name, age, gender, tel, address, regdate) values (SEQADDRESS.nextval, ?, ?, ?, ?, ?, default)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, name);
            pstat.setInt(2, age);
            pstat.setString(3, gender);
            pstat.setString(4, tel);
            pstat.setString(5, address);



            int result = pstat.executeUpdate();
            System.out.println(result);

            conn.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
