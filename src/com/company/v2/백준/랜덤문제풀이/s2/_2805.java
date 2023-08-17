package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tree = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] trees = new int[tree];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<tree; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0;
        int end = trees[tree - 1];

        while(start <= end) {
            int mid = start + (end - start) / 2;
            long getTree = calculate(mid, trees);

            if (getTree >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start - 1);
    }

    private static long calculate(int mid, int[] trees) {
        long sum = 0;
        for(int tree : trees) {
            if(tree > mid) {
                sum += tree - mid;
            }
        }

        return sum;
    }
}
