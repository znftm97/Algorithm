package com.company.v1.백준.소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측_9020 {
    private static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        notPrime = new boolean[10001];
        int testCase = Integer.parseInt(br.readLine());

        findPrime();

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            int num1 = N/2;
            int num2 = N/2;

            while (true) {
                if (!notPrime[num1] && !notPrime[num2]) {
                    sb.append(num1).append(" ").append(num2).append("\n");
                    break;
                } else {
                    num1--;
                    num2++;
                }
            }
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
