package sist.question.fileDirectory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Q114 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Downloads\\파일 디렉토리 문제\\확장자별 카운트");
        File[] files = file.listFiles();

        Map<String, Integer> set = new HashMap<>();

        for(File f : files) {
            if(!set.containsKey(f.getName().split("\\.")[1])) {
                set.put("." + f.getName().split("\\.")[1], 1);
            }
        }



    }
}
