package com.company.v2.릿코드.알고리즘.medium;

public class _849 {
    public int maxDistToClosest(int[] seats) {
        int start = 0;
        int end = 0;
        int frontDistance = 0;
        int backDistance = 0;
        int maxDistance = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                start = i;
                end = i;
                frontDistance = i;
                break;
            }
        }

        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                backDistance = seats.length - i - 1;
                break;
            }
        }

        while (end < seats.length) {
            if (seats[end] == 1) {
                maxDistance = Math.max(maxDistance, (end - start) / 2);
                start = end;
            }

            end++;
        }

        return Math.max(maxDistance, Math.max(frontDistance, backDistance));
    }
}
