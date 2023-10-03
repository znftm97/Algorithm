package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1).replace("{", "");
        String[] splits = s.split("}");
        int N = splits.length;
        String[][] arr = new String[N][N];

        for(int i = 0; i<splits.length; i++) {
            if(splits[i].charAt(0) == ',') {
                splits[i] = splits[i].substring(1);
            }

            arr[i] = splits[i].split(",");
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.length));

        Set<String> set = new HashSet<>();
        int[] results = new int[N];
        for(int i = 0; i<arr.length; i++) {
            for(String num : arr[i]) {
                if(!set.contains(num)) {
                    set.add(num);
                    results[i] = Integer.parseInt(num);
                }
            }
        }

        return results;
    }
}
