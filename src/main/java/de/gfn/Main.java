package de.gfn;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println((long) (1 / (Math.sqrt(2.0d)) * 11));
        ArrayList<Long> list = new ArrayList<>();
        list.add(10l);
        long sum = 0;
        for (long num : list) {
            sum += num*num;
        }
        System.out.println((long) (Math.sqrt(144/2)));
    }
}