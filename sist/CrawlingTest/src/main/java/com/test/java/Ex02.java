package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
    public static void main(String[] args) {
        String url = "https://land.naver.com/";

        try{
            Document doc = Jsoup.connect(url).get();

            Elements list = doc.select("#todayNewsListEle > h3");
            System.out.println(list);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
