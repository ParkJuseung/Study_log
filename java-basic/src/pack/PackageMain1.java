package pack;

public class PackageMain1 {
    public static void main(String[] args) {
        Data data = new Data(); // 같은 경로
        pack.a.User user = new pack.a.User(); // 다른 패키지
    }
}
