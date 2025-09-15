package com.itschool.oldHW.curs1ppt.ex1;

//Simple Output Program: Write a program that prints your name, age, and
//favorite color on three separate lines.

public class Main {
    public static void print(Me myself) {
        System.out.println("My name is: " + myself.getName());
        System.out.println("My age is: " + myself.getAge());
        System.out.println("My favorite color is: " + myself.getColor());
    }

    public static void main(String[] args) {
        System.out.println("Me, Myself &  I:");
        Me me = new Me();
        print(me);

        Me myself = new Me("Vlad", 25, "Cobalt");
        print(myself);

        Me I = new Me(myself);
        I.setName("Inverted "+ I.getName());
        I.setAge(-I.getAge());
        I.setColor("Whatever inverted " + I.getColor() + " is");
        print(I);
    }
}
