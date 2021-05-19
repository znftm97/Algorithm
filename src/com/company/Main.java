package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums) {

        int removeOverlapCount = 0;
        int getPocketmonCount = nums.length/2; // 내가 가져갈 포켓몬 수
        boolean[] overlapCheck = new boolean[200000];

        /*배열에서 숫자 중복 제거*/
        for (int i = 0; i < nums.length; i++) {
            overlapCheck[nums[i]] = true;
        }

        for (int i = 0; i < 200000; i++) {
            if (overlapCheck[i]) {
                removeOverlapCount++;
            }
        }

        /*경우의 수*/
        if (removeOverlapCount >= getPocketmonCount) {
            return getPocketmonCount;
        } else {
            return removeOverlapCount;
        }
    }
}