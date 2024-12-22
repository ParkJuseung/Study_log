package sist.question.stringSection;
import java.util.Scanner;

public class Q86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자 : ");
        String input = scanner.nextLine();
        String answer = "";

            for(int i = input.length();i>0;i = i-3){
                if (i>3){
                answer = "," + input.substring(i-3, i) + answer;
                }else if(i<=3) {
                    answer = (input.substring(0,i)) + answer;
                }
            }

        System.out.printf("결과 : %s", answer);
    }
}
