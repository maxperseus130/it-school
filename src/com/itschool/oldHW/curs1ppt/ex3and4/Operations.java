package com.itschool.oldHW.curs1ppt.ex3and4;

public class Operations {
    Operations() {
        numero_uno = 1;
        numero_dos = 2;
        caz = 0;
    }
    Operations(int numero_uno, int numero_dos) {
        this.numero_uno = numero_uno;
        this.numero_dos = numero_dos;
        caz = 1;
    }
    Operations(Operations op) {
        numero_uno = op.numero_uno;
        numero_dos = op.numero_dos;
        caz = 2;
    }

    public void setNumero_uno(int numero_uno) {
        this.numero_uno = numero_uno;
    }
    public void setNumero_dos(int numero_dos) {
        this.numero_dos = numero_dos;
    }

    public int getNumero_uno() {
        return numero_uno;
    }
    public int getNumero_dos() {
        return numero_dos;
    }

    public int add() {
        return numero_uno + numero_dos;
    }
    public int sub() {
        return numero_uno - numero_dos;
    }
    public int mul() {
        return numero_uno * numero_dos;
    }
    public int div() {
        return numero_uno / numero_dos;
    }
    public int mod() {
        return numero_uno % numero_dos;
    }

    public void print() {
        switch (caz) {
            case 1:
                System.out.println("\nParametrized");
                break;
            case 2:
                System.out.println("\nCopy");
                break;
            default:
                System.out.println("\nDefault");
        }

        System.out.println(numero_uno + " + " + numero_dos + " = " + add());
        System.out.println(numero_uno + " - " + numero_dos + " = " + sub());
        System.out.println(numero_uno + " * " + numero_dos + " = " + mul());
        System.out.println(numero_uno + " / " + numero_dos + " = " + div());
        System.out.println(numero_uno + " % " + numero_dos + " = " + mod());
    }

    private int numero_uno;
    private int numero_dos;
    private int caz;
}
