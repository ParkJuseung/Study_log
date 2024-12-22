package sist.question.stringSection;

import java.util.Scanner;

public class Q88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 : ");
        String input = scanner.nextLine();

        int count = 0;
        int index = -1;
        String[] arr = {"바보", "멍청이"};

        for(int i = 0; i<arr.length; i++){
            while ((index = input.indexOf(arr[i],index)) > -1) {
                count++;
                index = index + arr[i].length();
            }
            input = input.replace(arr[i], "**");
        }

        System.out.println(input);
        System.out.println(count);
    }
}
