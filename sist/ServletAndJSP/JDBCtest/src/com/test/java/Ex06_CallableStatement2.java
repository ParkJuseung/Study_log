package com.test.java;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Ex06_CallableStatement2 {
    public static void main(String[] args) {
//        m1();
//        m4();
        m5();
    }

    private static void m5() {


        DBUtil util = new DBUtil();
        Connection conn = null;
        CallableStatement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");

            String sql = "{ call procM5(?,?) }";
            stat = conn.prepareCall(sql);

            stat.setString(1, "f");
            stat.registerOutParameter(2, OracleTypes.CURSOR);

            stat.executeQuery();

            //out -> 오라클의 커서 -> 결과셋 참조 -> ResultSet
            rs = (ResultSet)stat.getObject(2);

            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
                System.out.println(rs.getString("gender"));
                System.out.println(rs.getString("tel"));
                System.out.println(rs.getString("address"));
            }

            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    private static void m4() {

        DBUtil util = new DBUtil();
        Connection conn = null;
        CallableStatement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");
            String sql = "{ call procM4(?,?,?,?,?,?) }";

            stat = conn.prepareCall(sql);

            //in
            stat.setString(1, "1");



            //out
            stat.registerOutParameter(2,OracleTypes.VARCHAR);
            stat.registerOutParameter(3,OracleTypes.NUMBER);
            stat.registerOutParameter(4,OracleTypes.VARCHAR);
            stat.registerOutParameter(5,OracleTypes.VARCHAR);
            stat.registerOutParameter(6,OracleTypes.VARCHAR);

            stat.executeQuery();

            System.out.println(stat.getString(2));
            System.out.println(stat.getString(3));
            System.out.println(stat.getString(4));
            System.out.println(stat.getString(5));
            System.out.println(stat.getString(6));

            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static void m1() {

        DBUtil util = new DBUtil();
        Connection conn = null;
        CallableStatement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");

            String sql = "{call ProcM3(?)}";
            stat = conn.prepareCall(sql);


            stat.registerOutParameter(1, OracleTypes.NUMBER);

            //일반 Select의 결과값
            stat.executeQuery();
            int count = stat.getInt(1);// stat.registerOutParameter의 반대값
            System.out.println(count);

            //PL/SQL 문에서 인출을 수행할 수 없습니다. ->
            //Out Parameter 결과값 -> ResultSet(x) -> 다른 방식
//            if(rs.next()){
//                System.out.println(rs.getInt(1));
//            }


            stat.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
