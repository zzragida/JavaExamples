package io.sweetheart.examples.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic1 {

    private static final int NUM_INCREMENTS = 1000;
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static void main(String[] args) {
        testUpdate();
    }

    private static void testUpdate() {
        atomicInt.set(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> {
                    Runnable task = () -> atomicInt.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });

        ConcurrentUtils.stop(executor);

        System.out.printf("Update: %d\n", atomicInt.get());
    }

    private static void testAccumulate() {

    }

    private static void testIncrement() {

    }
}
