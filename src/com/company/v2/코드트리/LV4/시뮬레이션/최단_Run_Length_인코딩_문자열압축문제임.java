package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최단_Run_Length_인코딩_문자열압축문제임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            String compressedStr = compress(str);
            minLen = Math.min(minLen, compressedStr.length());

            str = shift(str);
        }

        System.out.println(minLen);
    }

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int compressCnt = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            char now = str.charAt(i);
            char after = str.charAt(i + 1);

            if (now == after) {
                compressCnt++;
            } else {
                if (compressCnt == 1) {
                    sb.append(now).append(1);
                } else if (compressCnt > 1) {
                    sb.append(now).append(compressCnt);
                    compressCnt = 1;
                }
            }
        }

        if (compressCnt > 1) {
            sb.append(str.charAt(str.length() - 1)).append(compressCnt);
        } else {
            sb.append(str.charAt(str.length() - 1)).append(1);
        }

        return sb.toString();
    }

    private static String shift(String str) {
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(str.length() - 1));
        sb.append(str.substring(0, str.length() - 1));

        return sb.toString();
    }

}
