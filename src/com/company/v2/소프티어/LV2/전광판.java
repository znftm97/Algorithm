package com.company.v2.소프티어.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전광판 {
    private static String A,B;
    private static int[] a = new int[5];
    private static int[] b = new int[5];
    private static int[][] switchs = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t<testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            setting();
            sb.append(compare()).append("\n");
        }

        System.out.println(sb);
    }

    private static void setting() {
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);

        int idx = 0;
        for(int i = 5 - A.length(); i < 5; i++) {
            a[i] = A.charAt(idx++) - '0';
        }

        idx = 0;
        for(int i = 5 - B.length(); i < 5; i++) {
            b[i] = B.charAt(idx++) - '0';
        }
    }

    private static int compare() {
        int cnt = 0;

        for(int i = 4; i>=0; i--) {
            int aNum = a[i];
            int bNum = b[i];

            if(aNum == -1 && bNum == -1) continue;

            if(aNum == -1 && bNum != -1){
                for(int num : switchs[bNum]) {
                    cnt += num;
                }
                continue;
            } else if(aNum != -1 && bNum == -1) {
                for(int num : switchs[aNum]) {
                    cnt += num;
                }
                continue;
            }

            for(int j = 0; j<7; j++) {
                if(switchs[aNum][j] != switchs[bNum][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
