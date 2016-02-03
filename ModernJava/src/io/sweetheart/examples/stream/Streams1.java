package io.sweetheart.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Streams1 {
    public static void main(String[] args) {
        List<String> stringCollection  = new ArrayList();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // filtering
        System.out.println("Filtering");
        stringCollection.stream()
                        .filter((s) -> s.startsWith("a"))
                        .forEach(System.out::println);

        // sorting
        System.out.println("Sorting");
        stringCollection.stream()
                        .sorted()
                        .filter((s) -> s.startsWith("a"))
                        .forEach(System.out::println);

        // mapping
        System.out.println("Mapping");
        stringCollection.stream()
                        .map(String::toUpperCase)
                        .sorted((a, b) -> b.compareTo(a))
                        .forEach(System.out::println);

        // Matching
        System.out.println("Matching");
        boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);

        // Counting
        long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
        System.out.println(startsWithB);

        // reducing
        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }
}
