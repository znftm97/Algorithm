package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {
    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] abilities;
    static boolean[] teams;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        abilities = new int[N][N];
        teams = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0);

        System.out.println(result);
    }

    static void recursion(int depth, int start) {
        if (depth == N / 2) {
            result = Math.min(result, calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!teams[i]) {
                teams[i] = true;
                recursion(depth + 1, i + 1);
                teams[i] = false;
            }
        }
    }

    static int calculate() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(teams[i] && teams[j]) startTeam += abilities[i][j] + abilities[j][i];
                else if(!teams[i] && !teams[j]) linkTeam += abilities[i][j] + abilities[j][i];
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}
