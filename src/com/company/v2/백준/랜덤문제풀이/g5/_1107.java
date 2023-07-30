package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int breakCnt = Integer.parseInt(br.readLine());
        Set<String> breakNums = new HashSet<>();

        if(breakCnt == 0) {
            System.out.println(String.valueOf(N).length());
            return;
        }

        if(N == 100) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < breakCnt; i++) {
            breakNums.add(st.nextToken());
        }

        int result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);

            boolean hasBreakNum = false;
            for (int j = 0; j < s.length(); j++) {
                if (breakNums.contains(String.valueOf(s.charAt(j)))) {
                    hasBreakNum = true;
                    break;
                }
            }

            if (hasBreakNum) {
                continue;
            }

            int min = Math.abs(N - i) + s.length();
            result = Math.min(result, min);
        }

        System.out.println(result);
    }
}
