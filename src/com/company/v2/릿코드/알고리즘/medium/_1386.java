package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1386 {
    private Map<Integer, Set<Integer>> rowToColMap = new HashMap<>();

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        for (int[] reserved : reservedSeats) {
            int r = reserved[0];
            int c = reserved[1];
            rowToColMap.putIfAbsent(r, new HashSet<>());
            rowToColMap.get(r).add(c);
        }

        int result = 2 * (n - rowToColMap.size()); // 아무예약도 안된 줄은 2 그룹 예약 가능

        for (int key : rowToColMap.keySet()) {
            boolean noneReserved = true;
            if(canReserved(2, 5, key)) { // 왼쪽 먼저 확인
                result++;
                noneReserved = false;
            }

            if(canReserved(6, 9, key)) { // 오른쪽 확인
                result++;
                noneReserved = false;
            }

            if(noneReserved && canReserved(4, 7, key)) result++; // 왼쪽,오른쪽 둘다 예약안돼있으면 가운데 확인
        }

        return result;
    }

    private boolean canReserved(int start, int end, int key) {
        Set<Integer> values = rowToColMap.get(key);
        for (int i = start; i <= end; i++) {
            if(values.contains(i)) return false;
        }
        return true;
    }

}
