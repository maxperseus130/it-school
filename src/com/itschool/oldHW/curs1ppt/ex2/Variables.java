package com.itschool.oldHW.curs1ppt.ex2;

public class Variables {
    Variables() {
        intreg = 11;
        dublu = 22;
        caracter = 'c';
        sir = "Sir";
        caz = 0;
    }
    Variables(int intreg, double dublu, char caracter, String sir) {
        this.intreg = intreg;
        this.dublu = dublu;
        this.caracter = caracter;
        this.sir = sir;
        caz = 1;
    }
    Variables(Variables var) {
        intreg = var.intreg;
        dublu = var.dublu;
        caracter = var.caracter;
        sir = var.sir;
        caz = 2;
    }

    //Aici am descoperic ca daca scrii set sau get dupa modificatorul de acces
    //IntelliJ iti sugereaza setter/getter prescris

    public void setIntreg(int intreg) {
        this.intreg = intreg;
    }
    public void setDublu(double dublu) {
        this.dublu = dublu;
    }
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }
    public void setSir(String sir) {
        this.sir = sir;
    }

    public int getIntreg() {
        return intreg;
    }
    public double getDublu() {
        return dublu;
    }
    public char getCaracter() {
        return caracter;
    }
    public String getSir() {
        return sir;
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

        System.out.println("Integer is: " + intreg);
        System.out.println("Double is: " + dublu);
        System.out.println("Character is: " + caracter);
        System.out.println("String is: " + sir);
    }

    private int intreg;
    private double dublu;
    private char caracter;
    private String sir;
    private int caz;
}
