package ref.oop1;

public class MemberThis {
    String nameField;

    void initMembe(String nameParameter){
        nameField = nameParameter; // 매개변수에 없기 때문에 지역변수의 namefield를 사용
    }
}
