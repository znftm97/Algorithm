package com.company.v1.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수들의연속합_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        List<Integer> prime = new ArrayList<>();

        check[0] = check[1] = true; // 0과 1은 소수 아님

        /*에라토스테네스의 체로 소수 체크*/
        for (int i = 2; i*i <= N; i++) {
            if (check[i] == true) {
                continue;
            }

            for (int j = i * i; j <= N; j += i) {
                check[j] = true;
            }
        }

        /*소수만 prime에 삽입*/
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                prime.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

        while (true) {
            if (sum > N) {
                sum -= prime.get(start++);
            } else if (end == prime.size()) {
                break;
            } else {
                sum += prime.get(end++);
            }

            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}
