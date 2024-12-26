package ref.oop1;

public class BookMain {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayInfo();

        Book book2 = new Book("한강", "한강");
        book2.displayInfo();

        Book book3 = new Book("Java", "KIM", 100);
        book3.displayInfo();

    }
}
