package class1;

public class classStart3 {
    public static void main(String[] args) {

        //int a 처럼 Student student1은 Student타입의 student1이라는 변수를 생성하는 것을 의미한다.
        //new는 새로 생성한다는 뜻이다. new Student는 Student클래스 정보를 기반으로 새로운 객체를 생성하라는 뜻
        //Student studnet1 = x001; 처럼 참조값을 반환
        //x001에는 String name, int age, int grade가 있다.
        Student student1 = new Student(); //객체 또는 인스턴스 x001
        student1.name = "학생1"; // .을 통해 객체에 접근
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student(); //객체 또는 인스턴스 x002
        student2.name = "학생2";
        student2.age = 15;
        student2.grade = 90;

        System.out.println(student1);
        System.out.println(student2);
    }
}
