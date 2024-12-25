package inflearn.method;

public class Method1 {
    public static void main(String[] args) {
        boolean result = odd(2);
        System.out.println(result);
    }
    public static boolean odd(int i){
        if(i%2 == 1){
            System.out.println("홀수입니다.");
            return true;
        }
        else {
            System.out.println("짝수입니다.");
            return false;
        }
    }
}
