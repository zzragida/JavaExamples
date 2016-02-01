package io.sweetheart.examples;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int n;
        int status = 1;
        int num = 3;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = input.nextInt();

        if (n >= 1) {
            System.out.println("First " + n + " prime numbers are: 2");
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < Math.sqrt(num); j++) {
                if (num % j == 0) {
                    status = 0;
                    break;
                }
            }

            if (status != 0) {
                System.out.println(num);
                i++;
            }
            status = 1;
            num++;
        }
    }
}
