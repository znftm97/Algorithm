package com.company.v1.코드트리.알고리즘기본.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장먼저나오는숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;
            int minIndex = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid] >= target) {
                    end = mid - 1;
                    minIndex = Math.min(minIndex, mid);
                } else {
                    start = mid + 1;
                }
            }

            if (nums[minIndex] == target) {
                sb.append(minIndex + 1).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }

}
