package com.test.java;

public class Ex04 {
    public static void main(String[] args) {
        //시작하는 """는 다른 내용을 뒤에 적을 수 없다. (반드시 개행) (주석도 안됨)
        //모든 라인에서 가장 왼쪽에 있는 문장이 기준이 됨
        String txt1 = """
                        문자열
                        하나
                        둘
                        셋
                      """;
        System.out.println(txt1);

        //모든 엔터가 \n으로 통일됨
        String txt2 = """
                        문자열\r\n
                        하나\r
                        둘\n
                        셋
                      """;
        System.out.println(txt2);

        //이스케이프 처리가 필요없음
        String txt3 = """
                        문자열
                        하나
                        안녕하세요. "홍길동"입니다.
                        둘
                        셋
                      """;
        System.out.println(txt3);


        //한줄로 출력
        String txt4 = """
                        문자열\
                        하나\
                        안녕하세요. "홍길동"입니다.\
                        둘\
                        셋\
                      """;
        System.out.println(txt4);
    }

}
