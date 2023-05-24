package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> needRocks = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < capacity.length; i++) {
            needRocks.add(capacity[i] - rocks[i]);
        }

        Collections.sort(needRocks);

        for (int needRack : needRocks) {
            additionalRocks -= needRack;

            if(additionalRocks <0) return result;
            else result++;
        }

        return result;
    }
}
