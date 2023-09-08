package com.company.v2.프로그래머스.알고.LV2;

import java.math.BigInteger;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        int result = 0;

        if(check(gcdA, arrayB)) {
            result = Math.max(result, gcdA);
        }

        if(check(gcdB, arrayA)) {
            result = Math.max(result, gcdB);
        }

        return result;
    }

    static int getGcd(int[] arr) {
        if(arr.length == 1) return arr[0];

        int gcd = gcd(arr[0], arr[1]);
        for(int i = 2; i<arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }

        return gcd;
    }

    static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    static boolean check(int gcd, int[] arr) {
        for(int num : arr) {
            if(num % gcd == 0) return false;
        }

        return true;
    }
}
