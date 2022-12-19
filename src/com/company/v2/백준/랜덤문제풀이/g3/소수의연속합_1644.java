package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합_1644 {
    private static boolean[] notPrimes;
    private static List<Integer> primes = new ArrayList<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        notPrimes = new boolean[N + 1];
        findPrime();

        int cnt = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if(end >= primes.size() || end < start) {
                break;
            }

            int sum = sum(start, end);

            if (sum == N) {
                cnt++;
                end++;
            }

            if (sum < N) {
                end++;
            } else {
                start++;
            }
        }

        System.out.println(cnt);
    }

    private static void findPrime(){
        notPrimes[0] = notPrimes[1] = true;

        for (int i = 2; i < Math.sqrt(notPrimes.length); i++) {
            if(notPrimes[i]) continue;

            for (int j = i * i; j < notPrimes.length; j += i) {
                notPrimes[j] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            if(!notPrimes[i]) primes.add(i);
        }
    }

    private static int sum(int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += primes.get(i);
        }

        return sum;
    }

}
