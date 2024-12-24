package array;

public class EnhacedFor {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        // iter
        for (int number : numbers) {
            System.out.println(number);
        }
        for(int num : numbers){
            System.out.println(num);
        }

    }
}
