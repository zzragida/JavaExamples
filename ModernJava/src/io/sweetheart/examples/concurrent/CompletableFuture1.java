package io.sweetheart.examples.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("42");
        future
                .thenAccept(System.out::println)
                .thenAccept(v -> System.out.println("done"));
    }
}
