package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = {500, 100, 50, 10, 5, 1};
        int leftMoney = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        int i = 0;

        while (true) {
            if (arr[i] <= leftMoney) {
                leftMoney = leftMoney - arr[i];
                count++;
            } else {
                i++;
            }

            if (leftMoney == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
