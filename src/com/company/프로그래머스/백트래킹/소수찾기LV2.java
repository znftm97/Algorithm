package com.company.프로그래머스.백트래킹;

import java.util.ArrayList;
import java.util.List;

public class 소수찾기LV2 {
    private static List<Integer> nums = new ArrayList<>();
    private static boolean[] visit;

    public int solution(String numbers) {

        visit = new boolean[7];
        String tmp = "";
        for (int i = 1; i <= numbers.length(); i++) {
            makeComb(numbers, i, tmp);
        }

        int count = 0;
        for (int num : nums) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    private static void makeComb(String numbers, int depth, String tmp){
        if (tmp.length() == depth && !nums.contains(Integer.parseInt(tmp))) {
            nums.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(visit[i]) continue;

            visit[i] = true;
            tmp += numbers.charAt(i);
            makeComb(numbers, depth, tmp);
            visit[i] = false;
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }

    private static boolean isPrime(int num){
        if(num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

}
