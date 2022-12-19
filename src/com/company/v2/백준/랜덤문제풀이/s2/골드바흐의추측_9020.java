package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측_9020 {
    private static boolean[] isNotPrime;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        isNotPrime = new boolean[10001];

        int tc = Integer.parseInt(br.readLine());

        findPrime();

        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            search(N);
        }

        System.out.println(sb);
    }

    private static void search(int N) {

        int partition1 = N / 2;
        int partition2 = N - partition1;

        while (true) {

            if (!isNotPrime[partition1] && !isNotPrime[partition2]) {
                sb.append(partition1).append(" ").append(partition2).append("\n");
                return;
            }

            partition1 -= 1;
            partition2 += 1;
        }

    }

    private static void findPrime(){
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isNotPrime.length); i++) {
            if(isNotPrime[i]) continue;
            for (int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

}
