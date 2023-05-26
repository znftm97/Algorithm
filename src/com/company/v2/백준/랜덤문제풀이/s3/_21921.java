package com.company.v2.백준.랜덤문제풀이.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int period = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < period; i++) {
            sum += nums[i];
        }

        int max = sum;
        int cnt = 1;
        for (int i = period; i < N; i++) {
            sum += nums[i] - nums[i - period];
            if(max == sum) cnt++;
            else if (max < sum) {
                max = sum;
                cnt = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}
