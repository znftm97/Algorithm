package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num = Integer.parseInt(st.nextToken());
        long exponent = Integer.parseInt(st.nextToken());
        long divisor = Integer.parseInt(st.nextToken());

        System.out.println(pow(num, exponent, divisor));
    }

    private static long pow(long num, long exponent, long divisor){

        if (exponent == 1) {
            return num % divisor;
        }

        long half = pow(num, exponent / 2, divisor);

        if (exponent % 2 == 1) {
            return (half * half % divisor) * num % divisor;
        }

        return half * half % divisor;
    };

}
