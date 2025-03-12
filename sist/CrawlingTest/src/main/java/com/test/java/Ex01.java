package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex01 {
    public static void main(String[] args) {
        String url = "https://jsoup.org/";
        //Ex01.java

        //Jsoup
        // 자바 프로그램 -> 브라우저처럼 사이트 접속 -> 접속한 페이지 소스 읽기 -> 소스 분석 -> 탐색 -> 원하는 데이터 추출

        try{
            Document doc = Jsoup.connect(url).get();

//            doc.getElementById(url);
//            doc.getElementsByClass(url);
//
//
            Elements list = doc.select(".content > .col1 > h1");

            System.out.println(list.size());
            System.out.println(list.get(0).text());




        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
