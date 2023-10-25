package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1062 {
    static List<String> words = new ArrayList<>();
    static boolean[] knowAlphabets = new boolean[26];
    static int N, K, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words.add(s.substring(4, s.length() - 4));
        }

        knowAlphabets['a' - 'a'] = true;
        knowAlphabets['n' - 'a'] = true;
        knowAlphabets['t' - 'a'] = true;
        knowAlphabets['i' - 'a'] = true;
        knowAlphabets['c' - 'a'] = true;

        K -= 5;
        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        if (K == depth) {
            result = Math.max(result, calculateCanReadWord());
            return;
        }

        for (int i = start; i < 26; i++) {
            if (knowAlphabets[i]) {
                continue;
            }

            knowAlphabets[i] = true;
            dfs(depth + 1, i + 1);
            knowAlphabets[i] = false;
        }
    }

    static int calculateCanReadWord() {
        int canReadWordCnt = 0;

        for (String word : words) {
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (!knowAlphabets[word.charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                canReadWordCnt++;
            }
        }

        return canReadWordCnt;
    }
}
