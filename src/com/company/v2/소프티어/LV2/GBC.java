package com.company.v2.소프티어.LV2;

import java.util.*;
import java.io.*;


public class GBC {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[101];
        int[] b = new int[101];

        int start = 1;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int j = start; j<start + len; j++){
                a[j] = speed;
            }
            start += len;
        }

        start = 1;
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int j = start; j<start + len; j++){
                b[j] = speed;
            }
            start += len;
        }

        int result = 0;
        for(int i = 1; i<=100; i++){
            if(a[i] < b[i]) {
                result = Math.max(result, b[i] - a[i]);
            }
        }

        System.out.println(result);
    }
}
