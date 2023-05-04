package com.company.v2.릿코드.알고리즘.easy;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i][0] = 1;
        }

        for (int r = 1; r < numRows; r++) {
            for (int c = 1; c <= r; c++) {
                arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            List<Integer> list = new ArrayList<>();
            for (int c = 0; c <= r; c++) {
                list.add(arr[r][c]);
            }
            result.add(list);
        }

        return result;
    }
}
