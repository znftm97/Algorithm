package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        List<int[]> mergeNums = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));


        for (int[] interval : intervals) {
            if(mergeNums.isEmpty()) mergeNums.add(interval);

            int upEnd = mergeNums.get(mergeNums.size() - 1)[1];
            int downStart = interval[0];

            if (upEnd >= downStart) mergeNums.get(mergeNums.size() - 1)[1] = Math.max(upEnd, interval[1]);
            else mergeNums.add(interval);
        }

        return mergeNums.toArray(new int[0][]);
    }
}
