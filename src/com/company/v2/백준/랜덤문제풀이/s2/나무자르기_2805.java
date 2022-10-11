package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeCnt = Integer.parseInt(st.nextToken());
        int targetTreeLen = Integer.parseInt(st.nextToken());
        trees = new int[treeCnt];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < treeCnt; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0;
        int end = trees[treeCnt - 1];
        int maxH = Integer.MIN_VALUE;

        while (start <= end) {
            int h = (start + end) / 2;
            long sumTreeLen = sumTreeLen(h);

            if (targetTreeLen > sumTreeLen) {
                end = h - 1;
            } else {
                start = h + 1;
                maxH = Math.max(maxH, h);
            }
        }

        System.out.println(maxH);
    }

    private static long sumTreeLen(long h) {
        long sum = 0;

        for (long treeLen : trees) {
            if (treeLen > h) {
                sum += treeLen - h;
            }
        }

        return sum;
    }

}

