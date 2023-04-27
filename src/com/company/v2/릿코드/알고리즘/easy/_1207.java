package com.company.v2.릿코드.알고리즘.easy;

import java.util.HashSet;
import java.util.Set;

public class _1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] positiveCounts = new int[1001];
        int[] negativeCounts = new int[1001];
        int zeroCnt = 0;

        for (int num : arr) {
            if(num == 0) zeroCnt++;
            else if(num > 0) positiveCounts[num]++;
            else negativeCounts[num * -1]++;
        }

        Set<Integer> set = new HashSet<>();
        if(zeroCnt != 0) set.add(zeroCnt);

        for (int num : positiveCounts) {
            if(num == 0) continue;
            if (set.contains(num)) return false;

            set.add(num);
        }

        for (int num : negativeCounts) {
            if(num == 0) continue;
            if (set.contains(num)) return false;

            set.add(num);
        }

        return true;
    }

}
