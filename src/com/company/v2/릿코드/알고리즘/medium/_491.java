package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _491 {
    private int[] copyNums;
    private List<Integer> combineNums = new ArrayList<>();
    private Set<List<Integer>> results = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        copyNums = nums;
        recursion(0);
        return new ArrayList<>(results);
    }

    private void recursion(int start) {
        if (combineNums.size() >= 2) {
            results.add(new ArrayList<>(combineNums));
        }

        for (int i = start; i < copyNums.length; i++) {
            if (combineNums.size() == 0 || copyNums[i] >= combineNums.get(combineNums.size() - 1)) {
                combineNums.add(copyNums[i]);
                recursion(i + 1);
                combineNums.remove(combineNums.size() - 1);
            }
        }
    }
}
