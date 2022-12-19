package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
    private static String[] alphabets;
    private static boolean[] visit;
    private static int pwLen, alphabetCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pwLen = Integer.parseInt(st.nextToken());
        alphabetCnt = Integer.parseInt(st.nextToken());
        alphabets = new String[alphabetCnt];
        visit = new boolean[alphabetCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alphabetCnt; i++) {
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);

        getPassword(0, 0);
    }

    private static void getPassword(int start, int cnt){
        if (cnt == pwLen) {
            int jaum = 0;
            int moum = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < alphabetCnt; i++) {
                if (visit[i]) {
                    sb.append(alphabets[i]);

                    if (alphabets[i].equals("a") || alphabets[i].equals("e") || alphabets[i].equals("i") ||
                            alphabets[i].equals("o") || alphabets[i].equals("u")) {
                        jaum++;
                    } else moum++;
                }
            }

            if (jaum >= 1 && moum >= 2) System.out.println(sb);
        }

        for (int i = start; i < alphabetCnt; i++) {
            visit[i] = true;
            getPassword(i + 1, cnt + 1);
            visit[i] = false;
        }

    }

}
