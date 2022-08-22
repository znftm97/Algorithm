package com.company.v1.백준.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[n+1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (prime[j]) continue;
                prime[j] = true;
                count++;

                if (count == k) {
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
