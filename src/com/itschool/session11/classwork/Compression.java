package com.itschool.session11.classwork;

//Write a program that performs basic string compression by using the counts of repeated characters.
// For example, the string "aaabbbcccaaa" would become "a3b3c3a3".

public class Compression {
    public static void main(String[] args) {
        String comp = "aaaabbbbbbcccaaad";
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < comp.length(); i++){
            System.out.println("i: " + i + ", comp.charAT(i): " + comp.charAt(i));

            if(i < comp.length()-1 && comp.charAt(i) == comp.charAt(i+1)) {
                count++;
            } else {
                sb.append(comp.charAt(i));
                sb.append(count);
                count = 1;
            }
        }

        System.out.println(sb);
    }
}
