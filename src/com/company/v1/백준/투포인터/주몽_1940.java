package com.company.v1.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0, end=n-1;
        int count = 0;
        int sum = 0;

        while (true) {
            sum = arr[start] + arr[end];

            if(start == end) break;

            if (sum == m) {
                count++;
                start++;
            }

            if(sum > m) end--;
            else if(sum < m) start++;
        }

        System.out.println(count);
    }
}
