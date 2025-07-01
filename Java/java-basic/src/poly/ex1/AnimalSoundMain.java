package poly.ex1;

public class AnimalSoundMain {
    public static void main(String[] args) {
        Cow cow = new Cow();
        Cat cat = new Cat();
        Dog dog = new Dog();

        System.out.println("동물소리 테스트 시작");
        cow.sound();
        System.out.println("동물소리 종료");

        System.out.println("동물소리 테스트 시작");
        cat.sound();
        System.out.println("동물소리 종료");

        System.out.println("동물소리 테스트 시작");
        dog.sound();
        System.out.println("동물소리 종료");
    }
}
