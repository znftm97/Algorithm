package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int people = Integer.parseInt(br.readLine());
        int[] arr = new int[people];
        int[] arr2 = new int[people];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < people; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;

        for (int i = 0; i < people; i++) {
            sum += arr[i];
            arr2[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < people; i++) {
            sum += arr2[i];
        }

        System.out.println(sum);
    }
}
