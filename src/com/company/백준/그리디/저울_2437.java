package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] plumbs = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            plumbs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(plumbs);

        int sum = 1;
        for (int i = 0; i < n; i++) {
            if(sum < plumbs[i]) break;
            sum += plumbs[i];
        }

        System.out.println(sum);
        br.close();
    }
}
