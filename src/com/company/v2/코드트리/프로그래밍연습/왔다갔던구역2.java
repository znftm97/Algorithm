package com.company.v2.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 왔다갔던구역2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] x1 = new int[N + 1];
        int[] x2 = new int[N + 1];
        int[] checked = new int[2100];
        int curIdx = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            if (command.equals("L")) {
                x1[i] = curIdx - move;
                x2[i] = curIdx;
                curIdx -= move;
            } else {
                x1[i] = curIdx;
                x2[i] = curIdx + move;
                curIdx += move;
            }

            x1[i] += 1000;
            x2[i] += 1000;
        }

        for (int i = 0; i < N; i++) {
            for (int j = x1[i]; j < x2[i]; j++) {
                checked[j]++;
            }
        }

        for (int i = 0; i < checked.length; i++) {
            if (checked[i] >= 2) {
                result++;
            }
        }

        System.out.println(result);
    }
}
