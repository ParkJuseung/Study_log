package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        //public 호출
        accessData.publicField = 1;
        accessData.publicMethod();

        //default 호출
        accessData.defaultField = 2;
        accessData.defaultMethod();

        //private 호출
//        accessData.privateField = 3;
//        accessData.privateMethod();

        //innerAccess
        accessData.innerAccess();





    }
}
