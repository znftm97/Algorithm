package com.company.v1.동빈북.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] dc = {-1, 1, -1, 1, -2, -2, 2, 2};
        String pos = br.readLine();

        int r = pos.charAt(0) - 'a' + 1;
        int c = pos.charAt(1) - 48;

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr > 0 && nc > 0 && nr < 9 && nc < 9) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
