package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_Select {
    public static void main(String[] args) {

//        m1();
//        m2();
//        m3();
//        m4();
//        m5();
//        m6();
//        m7();
//        m8();
        m9();
    }

    private static void m9() {
        Scanner scan = new Scanner(System.in);

        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "hr", "java1234");
            stat = conn.createStatement();
            String sql = "select coutn(*) as cnt from tblInsa where buseo = '영업부'";

            rs = stat.executeQuery(sql);

            if(rs.next()){
                System.out.println("인원수 : " + rs.getString("cnt"));

            }

            rs.close();
            sql = "select * from tblInsa where buseo = '영업부'";

            rs = stat.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stat.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }


    private static void m8() {

        Scanner scan = new Scanner(System.in);

        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "hr", "java1234");
            stat = conn.createStatement();
            String sql = "select coutn(*) as cnt from tblInsa where buseo = '영업부'";

            rs = stat.executeQuery(sql);

            if(rs.next()){
                System.out.println("인원수 : " + rs.getString("cnt"));

            }

            rs.close();
            sql = "select * from tblInsa where buseo = '영업부'";

            rs = stat.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stat.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void m7() {
        //요구사항
        //특정 직원에게 보너스 지급
        //tblInsa + tblBonus
        // 1. tblInsa -> 직원번호, 이름, 부서, 직위 o
        // 2. 사용자로부터 보너스를 지급할 직원의 번호 선택
        // 3. 사용자로부터 보너스 금액도 입력받음
        // 4. 보너스 지급
        // 5. 지급된 내역을 출력 (tblBonus)직원번호, 이름, 부서, 직위, 보너스 금액) -> inner join
        // 쿼리 3개

        Scanner scan = new Scanner(System.in);

        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "hr", "java1234");
            stat = conn.createStatement();

            // 1. 직원 정보 출력
            String sql = "select NUM, NAME, BUSEO, JIKWI from TBLINSA";
            rs = stat.executeQuery(sql);
            System.out.println("직원번호\t이름\t부서\t직위");
            while (rs.next()) {
                System.out.println(rs.getString("NUM") + "\t" + rs.getString("NAME") + "\t" + rs.getString("BUSEO") + "\t" + rs.getString("JIKWI"));
            }
            rs.close();

            // 2. 사용자로부터 직원 번호 입력
            System.out.print("보너스를 줄 직원의 번호를 입력하세요 : ");
            String person = scan.nextLine();

            // 3. 사용자로부터 보너스 금액 입력
            System.out.print("보너스 금액을 입력하세요 : ");
            String bonus = scan.nextLine();

            // 4. 보너스 지급
            sql = String.format("insert into tblBonus(seq, NUM, BONUS) values (seqBonus.nextval, '%s', %s)", person, bonus);
            int result = stat.executeUpdate(sql);

            if (result > 0) {
                System.out.println("보너스 지급이 완료되었습니다.");
            } else {
                System.out.println("보너스 지급에 실패했습니다.");
            }

            // 5. 지급된 내역 출력
            sql = "select A.NUM, A.NAME, A.BUSEO, A.JIKWI, B.BONUS " +
                    "from tblInsa A " +
                    "inner join tblBonus B on A.NUM = B.NUM " +
                    "where A.NUM = '" + person + "'";
            rs = stat.executeQuery(sql);

            System.out.println("번호\t이름\t부서\t직위\t보너스금액");
            while (rs.next()) {
                System.out.println(rs.getString("NUM") + "\t" + rs.getString("NAME") + "\t" + rs.getString("BUSEO") + "\t" + rs.getString("JIKWI") + "\t" + rs.getString("BONUS"));
            }

            rs.close();
            stat.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void m6() {

        // insert -> select
        // 주소록 데이터 입력 -> 주소록 명단 출력하기
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름 : ");
        String name = scanner.nextLine();

        System.out.println("나이 : ");
        String age = scanner.nextLine();

        System.out.println("성별 : ");
        String sex = scanner.nextLine();

        System.out.println("전화번호 : ");
        String tel = scanner.nextLine();

        System.out.println("주소 : ");
        String address = scanner.nextLine();


        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;


        try {
            conn = util.open("localhost", "server", "java1234");
            stat = conn.createStatement();

            String sql = String.format("insert into tblAddress(seq, name, age, gender, tel, address) values (SEQADDRESS.nextval, '%s', %s, '%s', '%s', '%s')", name, age, sex, tel, address );

            System.out.println(sql);

            int result = stat.executeUpdate(sql);

            if(result > 0){

                //N행 N열
                sql = "select * from tblAddress order by seq desc";
                rs = stat.executeQuery(sql);

                while (rs.next()) {
                    System.out.printf("%s, %s, %s, %s%n",
                            rs.getString("seq"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("age"));
                }
                rs.close();
            }else {
                System.out.println("추가 실패");
            }

            System.out.println(result);


            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void m5() {

        Scanner scan = new Scanner(System.in);

        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "hr", "java1234");
            stat = conn.createStatement();

            String sql = "select distinct buseo from tblInsa order by buseo asc";

            rs = stat.executeQuery(sql);

            System.out.println("보고싶은 부서명을 입력하세요");
            while (rs.next()){
                System.out.println("- " + rs.getString("buseo"));
            }

            rs.close(); // 부서명 목록 닫기
            System.out.println("부서명: ");
            String buseo = scan.nextLine();

            sql = String.format("select name from tblInsa where buseo = '%s' order by name asc", buseo);

            rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close(); //직원 명단 목록 닫기
            stat.close(); // 더이상 SQL 실행할 일이 없으면 닫는다.
            conn.close(); // 접속이 필요없을 때 닫는다.

        } catch (Exception e) {

            throw new RuntimeException(e);
        }


    }


    private static void m4() {

        //다중값 반환
        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");
            stat = conn.createStatement();

            String sql = "select name from tblAddress order by name";

            rs = stat.executeQuery(sql);

//            while(rs.next()){
//                String name = rs.getString("name");
//                System.out.println(name);
//
//            }

            rs.close();
            stat.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void m3() {

        // 다중값 반환
        // 1행 N열
        DBUtil util = new DBUtil();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");
            stat = conn.createStatement();

            String sql = "select * from tblAddress where seq = 3";

            rs = stat.executeQuery(sql);

            if(rs.next()){

                String name = rs.getString("name");
                String age = rs.getString("age");
                String address = rs.getString("address");

                System.out.println(name);
                System.out.println(age);
                System.out.println(address);

            }else System.out.println("not found");

            rs.close();
            stat.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void m2() {
        DBUtil util = new DBUtil();

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");
            stat = conn.createStatement();

            String sql = "select name from tblAddress where seq = 3";

            rs = stat.executeQuery(sql);

            if(rs.next()){

                String name = rs.getString("name");
                System.out.println(name);

            }else System.out.println("");

            //현재 커서가 가르키고 있는 레코드의 원하는 컬럼 가져오기
//            int count = rs.getInt("cnt");

            rs.close();
            stat.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private static void m1() {
        DBUtil util = new DBUtil();

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = util.open("localhost", "server", "java1234");
            stat = conn.createStatement();

            String sql = "select count(*) as cnt from tblAddress";

            rs = stat.executeQuery(sql);
            rs.next(); // 커서 레코드 1줄 전진

            //현재 커서가 가르키고 있는 레코드의 원하는 컬럼 가져오기
//            int count = rs.getInt("cnt");
            String count = rs.getString("cnt");

            System.out.println(count);

            rs.close();
            stat.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
