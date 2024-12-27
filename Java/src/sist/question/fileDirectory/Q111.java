package sist.question.fileDirectory;

import java.io.File;
import java.util.Scanner;

public class Q111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("폴더 : ");
        String folder = sc.nextLine();
        System.out.println("확장자 : ");
        String filetype = sc.nextLine();

        File file = new File(folder);
        File[] files = file.listFiles();

        for(int i = 0; i<files.length;i++){
            if(files[i].getName().endsWith(filetype)){
                System.out.println(files[i].getName());
            }
        }
    }
}
