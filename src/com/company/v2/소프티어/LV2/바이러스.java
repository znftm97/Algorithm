package com.company.v2.소프티어.LV2;

import java.util.*;
import java.io.*;

public class 바이러스 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long virus = Long.parseLong(st.nextToken());
        int increase = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        for(int i = 0; i<time; i++){
            virus = (virus * increase) % 1000000007;
        }

        System.out.println(virus % 1000000007);
    }
}
