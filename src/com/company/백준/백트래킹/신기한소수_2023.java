package com.company.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수_2023 {
    private static int numLen;
    private static StringBuilder sb = new StringBuilder();
    private static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numLen = Integer.parseInt(br.readLine());
        visit = new boolean[10];

        dfs(0);
    }

    private static void dfs(int depth){
        if (depth == numLen && isPrime()) {
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i < 10; i++) {
            if(depth == 0 && (i == 1 || i == 4 || i == 6 || i == 8 || i == 9)) continue;

            visit[i] = true;
            sb.append(i);

            if (!isPrime()) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }

            dfs(depth + 1);;
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }

    private static boolean isPrime(){
        if(sb.length() == 0) return false;

        int num = Integer.parseInt(sb.toString());

        if(num < 2) return false;
        else if(num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

}
