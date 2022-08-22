package com.company.v1.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합5_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int start = 1, end = 1;
        int sum = 0;
        int count = 0;

        while (end < n) {

            if (sum == n) count++;

            if (sum >= n) sum -= arr[start++]; // >=로 해야 sum==n일 때 start 한칸 앞으로 이동함, >로 하면 무한루프에 빠짐
            else if (sum < n) sum += arr[end++];
        }

        System.out.println(count+1); // n 자기 자신 포함 +1

    }
}
