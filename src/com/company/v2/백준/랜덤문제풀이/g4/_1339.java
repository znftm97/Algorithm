package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(new ArrayList<>());
            for (int j = 0; j < s.length(); j++) {
                list.get(i).add(s.charAt(j));
            }
        }

        list.sort((o1, o2) -> Integer.compare(o2.size(), o1.size()));

        char[][] arr = new char[N][8];
        for (int i = 0; i < N; i++) {
            int start = 8 - list.get(i).size();
            int idx = 0;
            for (int j = start; j < 8; j++) {
                arr[i][j] = list.get(i).get(idx++);
            }
        }

        Map<Character, Integer> alphabetToNumMap = new HashMap<>();
        int num = 10;
        for (int c = 0; c < 8; c++) {
            for (int r = 0; r < N; r++) {
                if (!alphabetToNumMap.containsKey(arr[r][c])) {
                    alphabetToNumMap.put(arr[r][c], num--);
                }
            }
        }

        int sum = 0;
        for (List<Character> chars : list) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(alphabetToNumMap.get(c));
            }

            sum += Integer.parseInt(sb.toString());
        }

        System.out.println(sum);
    }
}
