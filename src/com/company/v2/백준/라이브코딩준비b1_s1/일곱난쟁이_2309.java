package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] heights = new int[9];
        int sum = 0;

        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        int n1 = 0;
        int n2 = 0;

        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    n1 = i;
                    n2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < heights.length; i++) {
            if(i == n1 || i == n2) {
                continue;
            }

            sb.append(heights[i]).append("\n");
        }

        System.out.println(sb);
    }

}
