public class Variable {
    public static void main(String[] args){
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간" + minute + "분");

        int totalMinue = (hour*60) + minute;
        System.out.println("총 " + totalMinue + "분");

        int x = 3;
        int y = 5;
        System.out.println("x = " + x + ", y = " + y);


        int temp = x;
        x = y;
        y = temp;
        System.out.println("x = " + x + ", y = " + y);

        // 유니코드 저장할 때는 char타입
        char var1 = 'A';
        char var2 = 65;

        System.out.println("var1 = " + var1 + " , var2 = " + var2);
    }
}
