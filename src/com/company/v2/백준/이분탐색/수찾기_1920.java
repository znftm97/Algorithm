package com.company.v2.백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] originNums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originNums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targetNums = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targetNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(originNums);

        for (int i = 0; i < M; i++) {
            int min = 0;
            int max = N - 1;
            int target = targetNums[i];
            boolean isEexist = false;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (originNums[mid] == target) {
                    sb.append("1").append("\n");
                    isEexist = true;
                    break;
                } else if (originNums[mid] > target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

            if(!isEexist) {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

}
