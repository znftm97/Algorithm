package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw = br.readLine();
        int[] dp = new int[pw.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        final int MOD = 1000000;

        if(pw.charAt(0) == '0') exit();

        for(int i = 2; i<=pw.length(); i++) {
            String before = String.valueOf(pw.charAt(i-2));
            String now = String.valueOf(pw.charAt(i-1));
            int sum = Integer.parseInt(before + now);

            if (now.equals("0")) {
                if(!before.equals("1") && !before.equals("2")) exit();
                else dp[i] = dp[i-2] % MOD;
            }
            else if(before.equals("0") || sum > 26) dp[i] = dp[i-1] % MOD;
            else dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[pw.length()] % MOD);
    }

    static void exit() {
        System.out.println(0);
        System.exit(0);
    }
}
