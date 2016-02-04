package io.sweetheart.examples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Streams12 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a1", "a2", "b1", "c1", "c2");

        test1();
        test2(strings);
        test3(strings);
        test4();
    }

    private static void test4() {
        List<String> values = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values
                .parallelStream()
                .sorted((s1, s2) -> {
                    return s1.compareTo(s2);
                })
                .count();
        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.printf("parallel sort took: %d ms", millis);
    }

    private static void test3(List<String> strings) {
        strings
                .parallelStream()
                .filter(s -> {
                    System.out.printf("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.printf("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.printf("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    }

    private static void test2(List<String> strings) {
        strings
                .parallelStream()
                .filter(s -> {
                    System.out.printf("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.printf("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.printf("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    }

    private static void test1() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }
}
