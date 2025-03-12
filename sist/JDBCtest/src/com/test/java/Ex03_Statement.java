//package com.test.java;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
//
//public class Ex03_Statement {
//    public static void main(String[] args) {
//        // Connection : 연결, 종료
//
//        // Statement : 모든 SQl 실행
////        m1();
////        m2();
////        m3();
////        m4();
////        m5();
////        m6();
//    }
//
//
//    private static void m6() {
//
//        // UI -> 사용자 데이터 입력 + DB에 저장
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("이름 : ");
//        String name = scanner.nextLine();
//
//        System.out.println("나이 : ");
//        String age = scanner.nextLine();
//
//        System.out.println("성별 : ");
//        String sex = scanner.nextLine();
//
//        System.out.println("전화번호 : ");
//        String tel = scanner.nextLine();
//
//        System.out.println("주소 : ");
//        String address = scanner.nextLine();
//
//
//        Connection conn = null;
//        Statement stat = null;
//        DBUtil util = new DBUtil();
//
//
//        try {
////            conn = util.open("localhost", "server", "java1234");
//            stat = conn.createStatement();
//
//            String sql = String.format("insert into tblAddress(seq, name, age, gender, tel, address) values (SEQADDRESS.nextval, '%s', %s, '%s', '%s', '%s')", name, age, sex, tel, address );
//
//            System.out.println(sql);
//
//            int result = stat.executeUpdate(sql);
//
//            System.out.println(result);
//
//
//            stat.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
////
////    private static void m5() {
////
////        //반환값이 없는 모든 쿼리
////        // DML -> insert, update, delete
////        // DDL ->
////        // DCL ->
////        DBUtil util = new DBUtil();
////        Connection conn = null;
////        Statement stat = null;
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////            stat= conn.createStatement();
////
//////            String sql = """
//////                    create table tblAddress
//////            (
//////                seq    number primary key,
//////                name   varchar2(30) not null,
//////                age    number(3)    not null check ( age between 0 and 120),
//////                gender char(1)      not null check ( gender in ('m', 'f') ),
//////                tel varchar2(15) not null,
//////                address varchar2(300) not null,
//////                regdate date default sysdate not null
//////            )
//////            """;
////
////            String sql = "create sequence seqAddress";
////
////
////            int result = stat.executeUpdate(sql);
////
////            System.out.println(result);
////
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        } finally {
////
////            try {
////                stat.close();
////                conn.close();
////            } catch (SQLException e) {
////                throw new RuntimeException(e);
////            }
////
////        }
////
////    }
////
////
////    private static void m4() {
////
////
////        DBUtil util = new DBUtil();
////        Connection conn = null;
////        Statement stat = null;
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////            stat= conn.createStatement();
////
////            String sql = "delete tblAddress where name = '홍길동'";
////
////
////            int result = stat.executeUpdate(sql);
////
////            System.out.println(result);
////
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        } finally {
////
////            try {
////                stat.close();
////                conn.close();
////            } catch (SQLException e) {
////                throw new RuntimeException(e);
////            }
////
////        }
////
////
////    }
////
////    private static void m3() {
////
////        DBUtil util = new DBUtil();
////        Connection conn = null;
////        Statement stat = null;
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////            stat= conn.createStatement();
////
////            String sql = "update tblAddress set age = age + 1";
////
////            int result = stat.executeUpdate(sql);
////
////            System.out.println(result);
////
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        } finally {
////
////            try {
////                stat.close();
////                conn.close();
////            } catch (SQLException e) {
////                throw new RuntimeException(e);
////            }
////
////        }
////
////    }
////
////
////    private static void m2() {
////
////        //JDBC는 기본설정이 SQL 실행시 (execute...) 자동으로 commit이 호출된다. -> Rollback이 불가능함
////        //사용자 설정을 하면 내가 원하는 시점에 commit/ rollback 가능
////
////
////
////        //insert
////        Connection conn = null;
////        Statement stat = null;
////        DBUtil util = new DBUtil();
////
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////            stat = conn.createStatement();
////
////
////            if(!conn.isClosed()){
////
////
////                String sql = "insert into tblAddress(seq, name, age, gender, tel, address) values (SEQADDRESS.nextval, '아무개',  20, 'm', '010-9101-3085', '서울시 강남구 역삼동')";
////
////
////                int i = stat.executeUpdate(sql);// = Ctrl + Enter : 실행 구문
////
////                if(i > 0){
////                    System.out.println("추가 성공");
////                }else System.out.println("추가 실패");
////
////                // SQL 실행후 적용된 행의 개수
////                System.out.println(i); // 1
////
////                Scanner scanner = new Scanner(System.in);
////                scanner.nextLine();
////
////
////
////                conn.commit();
////
////                //자원 정리
////                stat.close();
////                conn.close();
////
////            }else {
////                System.out.println("DB접속 실패");
////            }
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
////
////    }
////
////    private static void m1() {
////        //insert
////        Connection conn = null;
////        Statement stat = null;
////        DBUtil util = new DBUtil();
////
////
////        try {
////            conn = util.open("localhost", "server", "java1234");
////            stat = conn.createStatement();
////
////
////            if(!conn.isClosed()){
////
////                //자바는 SQL을 모른다. -> SQL을 문자열로 인식
////
////                String sql = "insert into tblAddress(seq, name, age, gender, tel, address) values (SEQADDRESS.nextval, '홍길동',  20, 'm', '010-9101-3085', '서울시 강남구 역삼동')";
////
////                // 반환값이 없는 쿼리
////                // - int stat. executeUpdate(String sql)
////                // 반환값이 있는 쿼리
////                // - ResultSet = stat.executeQuery(String sql)
////
////                int i = stat.executeUpdate(sql);// = Ctrl + Enter : 실행 구문
////
////                if(i > 0){
////                    System.out.println("추가 성공");
////                }else System.out.println("추가 실패");
////
////                // SQL 실행후 적용된 행의 개수
////                System.out.println(i); // 1
////
////                //자원 정리
////                stat.close();
////                conn.close();
////
////            }else {
////                System.out.println("DB접속 실패");
////            }
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
////
//
//}
