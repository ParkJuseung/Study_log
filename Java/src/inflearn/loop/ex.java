package inflearn.loop;

public class ex {
    public static void main(String[] args) {
        int num = 2;
        int count = 0;

        while(count<10){
            System.out.println(num);
            num += 2;
            count++;
        }

        for(int i = 1; i<=10;i++){
            System.out.println(num);

            num = num + 2;
        }

    }
}
