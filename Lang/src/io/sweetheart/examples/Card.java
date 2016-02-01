package io.sweetheart.examples;

public class Card {

    private int number;
    private String name;

    public Card() {
        this.number = 0;
        this.name = "";
    }

    public Card(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String toString() {
        return "Number: " + this.number + ", Name: " + this.name;
    }

    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
