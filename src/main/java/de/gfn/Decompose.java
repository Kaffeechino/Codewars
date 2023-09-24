package de.gfn;


import java.util.ArrayList;
import java.util.Collections;

// If no valid solution exists return null
public class Decompose {
    int i = 1;
    ArrayList<Long> decompList = new ArrayList<>();

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

    long restPlace() {
        long wholeSpace = decompList.get(0)*decompList.get(0);
        long takenSpace = 0;
        for (int i = 1; i < decompList.size(); i++) {
            takenSpace += decompList.get(i) * decompList.get(i);
        }
        return wholeSpace-takenSpace;
    }

    public String decompose(long n) {
        decompList.add(n);
        long maxN = Math.min(n - 1, (long) Math.sqrt(restPlace()));
        if (n > 1 && maxN > 0)
            decompose(maxN);
        else if (restPlace() != 0 && i < decompList.get(0)) {
            decompose(decompList.get(0) - i++);
            decompList.clear();
        }
        else if (restPlace() == 0) decompList.remove(0);
        else return null;
        return listToStr(decompList);
    }
}
