package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int cnt = 0;

        while (true) {
            if (Integer.parseInt(b) < Integer.parseInt(a)) {
                b = "-1";
                break;
            }

            if (b.equals(a)) {
                break;
            }

            if (b.charAt(b.length() - 1) == '1') {
                b = b.substring(0, b.length() - 1);
                cnt++;
            } else if (Integer.parseInt(b) % 2 == 0) {
                b = String.valueOf(Integer.parseInt(b) / 2);
                cnt++;
            } else {
                b = "-1";
                break;
            }
        }

        if (b.equals("-1")) {
            System.out.println(-1);
        } else {
            System.out.println(cnt + 1);
        }

        br.close();
    }
}
