package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        int count = 0;
        long sum = 0;
        int num = 1;

        while (true) {
            sum += num++;
            count++;

            if (sum > s) break;
        }

        System.out.println(count - 1);
    }

}
