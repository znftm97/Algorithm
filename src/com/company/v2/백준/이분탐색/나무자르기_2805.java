package com.company.v2.백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeCount = Integer.parseInt(st.nextToken());
        int targetTreeLen = Integer.parseInt(st.nextToken());
        int[] treeLens = new int[treeCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeCount; i++) {
            treeLens[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treeLens);

        int min = 0;
        int max = treeLens[treeCount - 1];
        int result = 0;

        while (min <= max) {
            int h = (min + max) / 2;
            long getTreeLen = 0;

            for (int len : treeLens) {
                if (len > h) {
                    getTreeLen += len - h;
                }
            }

            if (getTreeLen >= targetTreeLen) {
                result = Math.max(h, result);
                min = h + 1;
            } else {
                max = h - 1;
            }
        }

        System.out.println(result);
    }

}
