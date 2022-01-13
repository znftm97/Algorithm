package com.company.백준.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준_4948 {
    private static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            notPrime = new boolean[2*N + 1];
            findPrime();

            int cnt = 0;
            for (int i = N+1; i <= 2 * N; i++) { // N보다 큰 소수라는 조건때문에 N+1부터
                if(!notPrime[i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void findPrime(){
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for (int j = i * i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

    }

}
