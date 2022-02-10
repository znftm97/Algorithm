package com.company.프로그래머스.LV2;

import java.util.StringTokenizer;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {

        String s = Integer.toString(n, k);
        int result = 0;

        StringTokenizer st = new StringTokenizer(s, "0");
        while (st.hasMoreTokens()) {
            if(isPrime(Long.parseLong(st.nextToken()))) result++;
        }

        return result;
    }

    private boolean isPrime(Long num){
        if(num == 2) return true;
        else if(num == 0 || num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

}
