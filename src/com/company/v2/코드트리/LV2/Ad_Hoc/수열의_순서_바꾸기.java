package com.company.v2.코드트리.LV2.Ad_Hoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열의_순서_바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        for (int i = N - 1; i >= 1; i--) {
            if (nums[i] < nums[i - 1]) {
                break;
            }

            cnt++;
        }

        System.out.println(N - cnt);
    }

}
