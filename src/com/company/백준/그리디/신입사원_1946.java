package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];
            int employeeCount = 1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, (a1, a2) -> a1[0] - a2[0]);

            int min = scores[0][1];
            for (int i = 1; i < n; i++) {
                if (scores[i][1] < min) {
                    employeeCount++;
                    min = scores[i][1];
                }
            }

            System.out.println(employeeCount);
        }
    }
}
