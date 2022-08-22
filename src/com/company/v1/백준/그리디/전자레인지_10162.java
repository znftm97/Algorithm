package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] buttonTimes = {300, 60, 10};
        int[] counts = new int[buttonTimes.length];

        for (int i = 0; i < buttonTimes.length; i++) {
            int buttonTime = buttonTimes[i];

            if(t < buttonTime){
                continue;
            }

            int count = t / buttonTime;
            t -= buttonTime*count;
            counts[i] = count;
        }

        if (t < buttonTimes[buttonTimes.length - 1] && t != 0) {
            System.out.println(-1);
        } else {
            for (int count : counts) {
                sb.append(count).append(" ");
            }
            System.out.println(sb);
        }
    }
}
