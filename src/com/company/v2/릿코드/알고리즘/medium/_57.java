package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for(int[] arr : intervals) {
            if(newInterval[1] < arr[0]) {
                result.add(newInterval);
                newInterval = arr;
            } else if(arr[1] < newInterval[0]) {
                result.add(arr);
            } else {
                newInterval[0] = Math.min(newInterval[0],arr[0]);
                newInterval[1] = Math.max(newInterval[1],arr[1]);
            }
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
