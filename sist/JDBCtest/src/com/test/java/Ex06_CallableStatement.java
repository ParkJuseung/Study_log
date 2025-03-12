//package com.test.java;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//
//public class Ex06_CallableStatementDemo {
//    public static void main(String[] args) {
////        temp();
////        m1();
////        m2();
//        m3();
//    }
//
//
//    private static void m2() {
//
//        DBUtil util = new DBUtil();
//        Connection conn = null;
//        CallableStatement stat = null;
//        ResultSet rs = null;
//
//        try {
//            conn = util.open("localhost", "server", "java1234");
//
//
//            String sql = "{call procM2(?, ?, ?, ?, ?)";
//            stat = conn.prepareCall(sql);
//
//            stat.setString(1, "고양이");
//            stat.setInt(2, 2);
//            stat.setString(3, "f");
//            stat.setString(4, "010");
//            stat.setString(5, "서울시");
//
//            int result = stat.executeUpdate();
//            System.out.println(result);
//
//            conn.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    }
//
////
////    private static void m1() {
////
////
////        DBUtil util = new DBUtil();
////        Connection conn = null;
////        CallableStatement stat = null;
////        ResultSet rs = null;
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////
////            String sql ="{ call procM1() }";
////            stat = conn.prepareCall(sql);
////
////            int result = stat.executeUpdate();
////            System.out.println(result);
////
////            stat.close();
////            conn.close();
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//
//
//    }
//
//
//    private static void temp() {
//
//        DBUtil util = new DBUtil();
//        Connection conn = null;
//        CallableStatement stat = null;
//        ResultSet rs = null;
//
//        try {
//            conn = util.open("localhost", "server", "java1234");
//
//
//
//            conn.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
