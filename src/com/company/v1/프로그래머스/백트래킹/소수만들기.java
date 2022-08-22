package com.company.v1.프로그래머스.백트래킹;

public class 소수만들기 {
    private static int count = 0;

    public int solution(int[] nums) {
        dfs(0, 0, nums, 0);
        return count;
    }

    private static void dfs(int depth, int num, int[] nums, int start) {
        if(depth == 3){
            if (isPrime(num)) count++;
            return;
        }

        for (int i = start; i < nums.length; i++) {
            num += nums[i];
            dfs(depth + 1, num, nums, i + 1);
            num -= nums[i];
        }
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

}
