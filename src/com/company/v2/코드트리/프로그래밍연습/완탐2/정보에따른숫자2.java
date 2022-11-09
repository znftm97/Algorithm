package com.company.v2.코드트리.프로그래밍연습.완탐2;

import java.util.*;
import java.io.*;

public class 정보에따른숫자2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] S = new int[100];
        int[] N = new int[100];

        int sIdx = 0;
        int nIdx = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String SN = st.nextToken();

            if (SN.equals("S")) {
                S[sIdx++] = Integer.parseInt(st.nextToken());
            } else {
                N[nIdx++] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int num = a; num <= b; num++) {
            int d1 = getNearestDistance(S, num);
            int d2 = getNearestDistance(N, num);

            if (d1 <= d2) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int getNearestDistance(int[] arr, int num) {
        int result = 1001;

        for (int i = 0; i < arr.length; i++) {
            result = Math.min(result, Math.abs(arr[i] - num));
        }

        return result;
    }

}