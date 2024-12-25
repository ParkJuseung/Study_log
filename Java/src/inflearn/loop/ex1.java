package inflearn.loop;

public class ex1 {
    public static void main(String[] args) {
        int max=10;
        int sum = 0;
//        for(int num = 1;num<=max; num++){
//            sum += num;
//        }
        int num = 1;
        while(num<=max){
            sum += num;
            num++;
        }
        System.out.println(sum);
    }
}
