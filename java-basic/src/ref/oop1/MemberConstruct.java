package ref.oop1;

public class MemberConstruct {
    String name;
    int age;
    int grade;


    MemberConstruct(String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
        System.out.println("생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
    }
    MemberConstruct(String name, int age){
        this(name, age, 50);
    }
}
