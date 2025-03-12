package com.test.java;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class Ex04 {
    public static void main(String[] args) {
//        m1();
//        m2();
        m3();

    }

    private static void m3() {
        try {
            Document doc = Jsoup.connect("http://localhost:8091/ex04.jsp").get();
            Elements list = doc.select("#list3 > li");

            for(Element li : list){
                System.out.println(Objects.requireNonNull(li.firstElementChild()).text());
                System.out.println(Objects.requireNonNull(li.lastElementChild()).text());
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void m2() {
        try {
            Document doc = Jsoup.connect("http://localhost:8091/ex04.jsp").get();
            Elements list = doc.select("#list1 > li");

            for(Element li : list){
                System.out.println(Objects.requireNonNull(li.firstElementChild()).text());
                System.out.println(Objects.requireNonNull(li.lastElementChild()).text());
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void m1() {
        try {
            // URL 요청 + 타임아웃 설정
            Connection.Response response = Jsoup.connect("http://localhost:8091/ex04.jsp")
                    .timeout(10000)
                    .execute();

            // HTTP 상태 코드 확인
            if (response.statusCode() == 200) { // HTTP 200
                Document doc = response.parse();
                Elements list = doc.select("#list1 > li");

                for (Element li : list) {
                    // NullPointer 예외 방지
                    if (li.firstElementChild() != null && li.lastElementChild() != null) {
                        System.out.println(li.firstElementChild().text());
                        System.out.println(li.lastElementChild().text());
                        System.out.println();
                    } else {
                        System.out.println("잘못된 요소 형식입니다.");
                    }
                }
            } else {
                // 서버 오류 메시지 출력
                System.err.println("HTTP 요청 실패. 상태 코드: " + response.statusCode());
            }
        } catch (IOException e) {
            System.err.println("문서를 가져오는 중 오류 발생: " + e.getMessage());
        }
    }

}
