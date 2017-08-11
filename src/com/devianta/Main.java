package com.devianta;

public class Main {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer("What's up dude?");
        Saver.save(tc);
        System.out.println("Ok");
    }
}
