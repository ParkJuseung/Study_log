package sist.question.classSection;

public class Q104 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        System.out.println(list);

        list.add("홍길동");
        list.add("아무개");
        list.add("강아지");
//        list.add("고양이");

        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
//        System.out.println(list.get(3));

        System.out.println(list.size());
        System.out.println(list);
        list.add("고양이");
        System.out.println(list);
        list.add("거북이");

    }
}
