package com.company.v2.릿코드.알고리즘.medium;

public class _852 {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int now = arr[mid];
            int next = arr[mid + 1];

            if (now < next) {
                start = mid + 1;
            } else if (now > next) {
                end = mid;
            }
        }

        return end;
    }
}
