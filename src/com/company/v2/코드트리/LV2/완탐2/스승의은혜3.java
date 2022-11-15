package com.company.v2.코드트리.LV2.완탐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 스승의은혜3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int student = Integer.parseInt(st.nextToken());
        int totalMoney = Integer.parseInt(st.nextToken());
        int[][] arr = new int[student][2];

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> (a[0] + a[1])));

        for (int couponIdx = 0; couponIdx < student; couponIdx++) {
            int sum = 0;
            int ableGiveCnt = 0;

            for (int i = 0; i < student; i++) {
                if (i == couponIdx) {
                    sum += arr[i][0] / 2 + arr[i][1];
                } else {
                    sum += arr[i][0] + arr[i][1];
                }

                if (sum > totalMoney) {
                    break;
                }

                ableGiveCnt++;
            }

            result = Math.max(result, ableGiveCnt);
        }

        System.out.println(result);
    }

}
