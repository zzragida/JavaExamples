package io.sweetheart.examples.chapter02.item05;

public class Sum {

    public static void main(String[] args) {
        Long sum = 0L;

        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
