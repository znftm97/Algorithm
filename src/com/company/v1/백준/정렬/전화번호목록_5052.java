package com.company.v1.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호목록_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] phoneNums = new String[N];

            for (int i = 0; i < N; i++) {
                phoneNums[i] = br.readLine();
            }

            Arrays.sort(phoneNums);
            boolean flag = false;

            for (int i = 0; i < N - 1; i++) {
                if (phoneNums[i + 1].startsWith(phoneNums[i])) {
                    sb.append("NO").append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}
