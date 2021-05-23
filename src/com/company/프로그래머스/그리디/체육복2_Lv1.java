package com.company.프로그래머스.그리디;

import java.io.IOException;

public class 체육복2_Lv1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];

        for (int i : reserve) {
            arr[i - 1]++;
        }
        for (int i : lost) {
            arr[i - 1]--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // 0보다작을경우 즉 도난당한 학생인 경우
                if (i != arr.length - 1 && arr[i + 1] > 0) {  // 맨끝요소가 아니고, 다음 학생이 여부의 체육복이 있는 경우
                    arr[i]++;
                    arr[i + 1]--;
                } else if (i != 0 && arr[i - 1] > 0) { // 맨첫요소가 아니고, 앞에 학생이 여부의 체육복이 있는 경우
                    arr[i]++;
                    arr[i-1]--;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0) count++;
        }

        return count;
    }
}
