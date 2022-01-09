package com.company.프로그래머스.구현;

import java.util.*;

public class 영어끝말잇기_LV2 {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[n][n];
        int r = -1;
        int c = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i % 3 == 0){
                    r++;
                } else if(i % 3 == 1){
                    c++;
                } else if(i % 3 == 2) {
                    r--;
                    c--;
                }

                arr[r][c] = num++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0) break;
                answer.add(arr[i][j]);
            }
        }

        return answer;
    }
}
