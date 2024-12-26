package ref;

public class Method2 {
    public static void main(String[] args) {
//        Student student1 = new Student();
//        student1.name = "학생1";
//        student1.age = 15;
//        student1.grade = 90;

        Student a = new Student();
        Student b = new Student();
        Student c = new Student();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
//        Student student2 = new Student();
//        student2.name = "학생2";
//        student2.age = 16;
//        student2.grade = 80;

//        initStudent(student1, "학생1", 15, 90);
//        initStudent(student2, "학생2", 16, 80);

        Student student1 = createStudent("학생1", 15, 90);
        Student student2 = createStudent("학생2", 16, 80);
        printStudent(student1);
        printStudent(student2);
    }

    static Student createStudent(String name, int age, int grade){
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }
    static void printStudent(Student student){
        System.out.println("이름 : " + student.name + " 나이 : " + student.age + " 성적 : " + student.grade );

    }
//    static void initStudent(Student student, String name, int age, int grade){
//        student.name = name;
//        student.age = age;
//        student.grade = grade;
//    }
}
