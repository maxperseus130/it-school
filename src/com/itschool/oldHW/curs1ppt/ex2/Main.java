package com.itschool.oldHW.curs1ppt.ex2;

//Using Variables: Write a program that defines four different variables
//(an integer, a double, a character, and a string), assigns them values,
//and then prints them out.


public class Main {

    public static void main(String[] args) {
        Variables var = new Variables();
        var.print();

        Variables varp = new Variables(1, 2, 'a', "AAA");
        varp.print();

        Variables varc = new Variables(varp);
        varc.print();

        varc.setIntreg(-varp.getIntreg());
        varc.setDublu(-varp.getDublu());
        varc.setCaracter('z');
        varc.setSir("ZZZ");
        varc.print();
    }
}
