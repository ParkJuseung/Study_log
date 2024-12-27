package sist.question.fileDirectory;

import java.io.File;
import java.util.Scanner;

public class Q112 {
    public static void main(String[] args) {
        String oldPath = "C:\\Users\\user\\Downloads\\파일 디렉토리 문제\\확장자별 카운트\\모니터10.png";
        String newPath = "C:\\Users\\user\\Downloads\\파일 디렉토리 문제\\모니터10.png";
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);


        System.out.println("파일 이동을 실행합니다.");
        if(!newFile.exists()) {
            oldFile.renameTo(newFile);
            System.out.println("파일 이동이 완료되었습니다.");
        } else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요? [y/n]");
            String answer = scanner.next();

            if(answer.equals("y")) {
                oldFile.renameTo(newFile);
                System.out.println("파일 이동이 완료되었습니다.");
            }else if(answer.equals("n")) {
                System.out.println("작업을 취소합니다.");
            } else System.out.println("잘못된 입력입니다.");

            scanner.close();
        }


    }
}
