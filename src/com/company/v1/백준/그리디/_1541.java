package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = 111111;
        while (st.hasMoreTokens()) {
            int tmp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                tmp += Integer.parseInt(st2.nextToken());
            }

            if (sum == 111111) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}
