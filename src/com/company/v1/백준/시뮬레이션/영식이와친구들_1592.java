package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이와친구들_1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] friends = new int[N + 1];

        int result = 0;
        int ballPos = 1;
        friends[ballPos]++;

        while (true) {
            if (friends[ballPos] == M) {
                break;
            }

            if (friends[ballPos] % 2 == 0) {
                ballPos -= L;
            } else {
                ballPos += L;
            }

            if (ballPos > N) {
                ballPos %= N;
            } else if (ballPos < 1) {
                ballPos += N;
            }

            friends[ballPos]++;
            result++;
        }

        System.out.println(result);
        br.close();
    }

}
