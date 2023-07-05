package com.company.v2.릿코드.알고리즘.medium;

public class _875 {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (valid(mid, h, piles)) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    private boolean valid(int mid, int h, int[] piles) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += pile / mid;
            if(pile % mid != 0) cnt++;
        }

        return cnt <= h;
    }
}
