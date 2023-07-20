package com.company.v2.프로그래머스.알고.LV2;

public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        int[] result = new int[]{0, 1000001};

        while(end < sequence.length){
            if(sum == k) {
                if(result[1] - result[0] > end - start){
                    result[0] = start;
                    result[1] = end;
                }

                sum -= sequence[start++];
            } else if (sum < k) {
                end++;
                if(end < sequence.length) {
                    sum += sequence[end];
                }
            } else {
                sum -= sequence[start++];
            }
        }

        return result;
    }
}
