package com.itschool.oldHW.curs1ppt.ex1;

public class Me {
    Me() {
        System.out.println("\nDefault");
        name = "First_Name";
        age = 0;
        color = "Fav_Color";
    }
    Me(String name, int age, String color) {
        System.out.println("\nParameterized");
        this.name = name;
        this.age = age;
        this.color = color;
    }
    Me(Me m){
        System.out.println("\nCopy");
        name = m.name;
        age = m.age;
        color = m.color;
    }

    public void setName(String n) {
         name = n;
    }
    public void setColor(String c) {
        color = c;
    }
    public void setAge(int a) {
        age = a;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getAge() {
        return age;
    }

    private String name, color;
    private int age;
}
