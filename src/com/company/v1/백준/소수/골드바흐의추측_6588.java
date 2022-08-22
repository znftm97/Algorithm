package com.company.v1.백준.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측_6588 {
    private static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        notPrime = new boolean[1000001];
        findPrime();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            boolean flag = false;

            for (int i = 2; i <= N / 2; i++) {
                if (!notPrime[i] && !notPrime[N - i]) {
                    sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void findPrime() {
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for (int j = i * i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }
    }

}
