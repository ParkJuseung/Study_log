package access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;
    public void publicMethod(){
        System.out.println("publicMethod호출 " + publicField);
    }
    void defaultMethod(){
        System.out.println("defaultMethod호출 " + defaultField);
    }

    private void privateMethod(){
        System.out.println("privateMethod호출 " + defaultField);
    }

    public void innerAccess() {
        //내부에서는 private에도 접근이 가능한 모습
        System.out.println("내부호출");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }

}
