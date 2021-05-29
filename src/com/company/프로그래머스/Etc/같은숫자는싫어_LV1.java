package com.company.프로그래머스.Etc;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어_LV1 {
    public  List<Integer> solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        return list;
    }
}
