package com.itschool.oldHW.curs1ppt.ex3and4;

//Operations: Write a program that performs various operations
//(addition, subtraction, multiplication, division, and modulus) on two numbers.
//The numbers can be hard-coded into the program. Print the result of each operation.

//Simple Input/Output: Write a program that asks the user to enter two numbers,
//performs addition on those numbers, and prints out the result.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations op = new Operations();
        op.print();

        Operations opp = new Operations(100, 183724);
        opp.print();

        Operations opc = new Operations(opp);
        opc.print();

        opc.setNumero_uno(opc.getNumero_dos());
        opc.setNumero_dos(opp.getNumero_uno());
        opc.print();

        Scanner num = new Scanner(System.in);
        System.out.println("\nAnd finally, for exercise 4, operations with your custom numbers");

        System.out.println("Numero Uno:");
        int numero_uno = num.nextInt();

        System.out.println("Numero Dos:");
        int numero_dos = num.nextInt();

        Operations op_custom = new Operations(numero_uno, numero_dos);
        op_custom.print();
    }
}
