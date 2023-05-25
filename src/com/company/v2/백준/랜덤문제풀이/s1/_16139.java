package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[][] accumulateSums = new int[S.length()][26];
        accumulateSums[0][S.charAt(0) - 'a']++;
        int question = Integer.parseInt(br.readLine());

        for (int i = 1; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                accumulateSums[i][j] = accumulateSums[i - 1][j];
            }
            accumulateSums[i][idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < question; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 0) sb.append(accumulateSums[end][target]).append("\n");
            else sb.append(accumulateSums[end][target] - accumulateSums[start - 1][target]).append("\n");
        }

        System.out.println(sb);
    }

}
