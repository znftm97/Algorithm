package com.company.v1.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최대H점수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int H = 1; H <= N; H++) {
            int cnt = 0;
            int l = L;

            for (int j = 0; j < N; j++) {
                if (H <= nums[j]) {
                    cnt++;
                } else if (l > 0 && (nums[j] + 1) == H) {
                    cnt++;
                    l--;
                }
            }

            if (H <= cnt) {
                result = Math.max(result, H);
            }
        }

        System.out.println(result);
    }

}
