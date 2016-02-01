package io.sweetheart.examples;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        int num, item, array[];

        // number of array
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        num = input.nextInt();

        // create array
        array = new int[num];
        System.out.println("Enter " + num + " integers");

        for (int i = 0; i < num; i++) {
            array[i] = input.nextInt();
        }

        // find item in array
        System.out.println("Enter the search value: ");
        item = input.nextInt();

        boolean find = false;
        for (int i = 0; i < num; i++) {
            if (item == array[i]) {
                find = true;
                break;
            }
        }

        if (find) {
            System.out.println(item + " exist in array.");
        }
    }
}
