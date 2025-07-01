package class1;

public class classStart4 {
    public static void main(String[] args) {

        Student student1 = new Student(); //객체 또는 인스턴스 x001
        student1.name = "학생1"; // .을 통해 객체에 접근
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student(); //객체 또는 인스턴스 x002
        student2.name = "학생2";
        student2.age = 15;
        student2.grade = 90;

        //변수에는 인스턴스의 참조값만 들어있다.
        // 자바에서 대입은 변수에 들어있는 값을 복사해서 전달한다.
        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;


        System.out.println(student1);
        System.out.println(student2);
    }
}
