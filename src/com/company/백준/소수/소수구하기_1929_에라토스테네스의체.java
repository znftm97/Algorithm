package com.company.백준.소수;

/*소수 개수 구하기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929_에라토스테네스의체 {

    private static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        notPrime = new boolean[N + 1];

        findPrime();

        for (int i = M; i <= N; i++) {
            if(!notPrime[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void findPrime(){
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i < Math.sqrt(notPrime.length); i++) {
            if(notPrime[i]) continue;
            for (int j = i * i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }
    }
}
