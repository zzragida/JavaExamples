package io.sweetheart.examples;

import java.util.Scanner;

public class FloydTriangle {

    public static void main(String[] args) {

        int rows, number = 1;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows for floyd's triangle:");

        rows = input.nextInt();
        System.out.println("Floyd's triangle");
        System.out.println("***********************");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }

            System.out.println();
        }
    }
}
