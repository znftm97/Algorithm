package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i > 0; i--) {
            int startScore = scores[i];
            int endScore = scores[i-1];

            if (startScore == 1 || endScore == 1) {
                break;
            }

            if (startScore < endScore) {
                cnt += endScore - startScore + 1;
                endScore -= endScore - startScore + 1;
            } else if (startScore == endScore) {
                cnt++;
                endScore -= 1;
            }

            scores[i - 1] = endScore;
        }

        System.out.println(cnt);
        br.close();
    }
}
