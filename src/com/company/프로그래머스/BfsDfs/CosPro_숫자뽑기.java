package com.company.프로그래머스.BfsDfs;

import java.util.*;

public class CosPro_숫자뽑기 {
    public int solution(int[] arr, int K) {
        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        for(int i = 0; i<=arr.length - K; i++){
            result = Math.min(result, arr[i+K-1] - arr[i]);
        }

        return result;
    }

}
