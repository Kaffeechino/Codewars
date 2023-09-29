package de.gfn;
// Square into Squares. Protect trees!
// https://www.codewars.com/kata/54eb33e5bc1a25440d000891

import java.util.ArrayList;
import java.util.Collections;

public class Decompose {
    String result;
    long original;
    ArrayList<Long> list = new ArrayList<>();


    String listToStr(ArrayList<Long> list) {
        if (list.isEmpty()) return null;
        else {
            String result = "";
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) result += list.get(i);
                else result += list.get(i) + " ";
            }
            return result;
        }
    }

    long listSum(ArrayList<Long> list) {
        long sum = 0;
        for (long num : list) {
            sum += num*num;
        }
        return sum;
    }
    long rest() {
        long rest = original*original - listSum(list);
        return rest;
    }

    public String decompose(long n) {
        if (result!=null) return result;
        original = Math.max(n, original);
        long ceiling = Math.min(n-1, (long)Math.sqrt(rest()));
        long floor = (long) Math.sqrt(rest()/2.0);
        for (long i = ceiling; i > floor; i--) {
            list.add(i);
            if (listSum(list) == original*original){
                result = listToStr(list);
                break;
            } else {
                if (i == 1) {
                    if(!list.isEmpty()) {
                        list.remove(list.size()-1);
                    }
                    return null;
                }
                if (i>1) decompose(i);
            }
        }
        if(!list.isEmpty()) {
            list.remove(list.size()-1);
        }
        return result;
    }
}
