package sist.question.fileDirectory;

import java.io.File;
import java.util.Scanner;

public class Q110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("파일 경로 : ");
        String root = scanner.nextLine();
        File file = new File(root);

        System.out.printf("파일명 : %s\n", file.getName());
        System.out.printf("종류 : %s\n", file.getName().split("\\.")[1]);
        System.out.printf("파일크기 : %s\n", file.length() );


    }
}
