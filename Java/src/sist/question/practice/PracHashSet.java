package sist.question.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PracHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(100);
        set.add(300);
        set.add(400);
        set.add(500);

        Iterator<Integer> iterator = set.iterator();
        System.out.println(iterator.hasNext());

        Consumer<Integer> consumer = a -> System.out.println(a);
        consumer.accept(10);

        BiConsumer<Integer, String> biConsumer = (n, s) -> System.out.printf("%s %d개", s, n);
        biConsumer.accept(10, "연필");



    }
}
