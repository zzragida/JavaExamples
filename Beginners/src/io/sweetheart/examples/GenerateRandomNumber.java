package io.sweetheart.examples;

import java.util.*;

public class GenerateRandomNumber {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Random Numbers: ");
        System.out.println("*********************");

        for (int i = 0; i <= 5; i++) {
            System.out.println(random.nextInt(200));
        }
    }
}
