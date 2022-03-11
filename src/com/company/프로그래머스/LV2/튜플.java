package com.company.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 튜플 {
    public List<Integer> solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "_");

        String[] split = s.split("_");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        List<Integer> result = new ArrayList<>();
        for (String str : split) {
            String[] tmp = str.split(",");

            for (int i = 0; i < tmp.length; i++) {
                int num = Integer.parseInt(tmp[i]);
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }

        return result;
    }

}
