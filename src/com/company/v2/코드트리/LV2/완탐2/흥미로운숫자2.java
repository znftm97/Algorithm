package com.company.v2.코드트리.LV2.완탐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 흥미로운숫자2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] checks = new int[10];

        for (int num = x; num <= y; num++) {
            if (isInterestingNum(num, checks)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isInterestingNum(int num, int[] checks) {
        Arrays.fill(checks, 0);

        int mod = 1;
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            int n = (num / mod) % 10;
            checks[n]++;
            mod *= 10;
        }

        int zeroCnt = 0;
        for (int i = 0; i < checks.length; i++) {
            if (checks[i] == 0) {
                zeroCnt++;
            }
        }

        if (zeroCnt != 8) {
            return false;
        }

        Arrays.sort(checks);

        if (checks[8] == 1 && checks[9] != 1) {
            return true;
        }

        return false;
    }

}
