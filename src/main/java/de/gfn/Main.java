package de.gfn;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int a = 12, b = 34, c = 56;
        String format = "Start:%03o | %3o | %3o";
        System.out.println(String.format(format,a,b,c));
    }
}