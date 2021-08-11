package com.company.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> list = new HashMap<>();
        List<String> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i < n+m; i++) {
            String str = br.readLine();
            list.put(str, list.getOrDefault(str, 0) + 1);
        }

        for (String key : list.keySet()) {
            if (list.get(key) == 2) {
                count++;
                answer.add(key);
            }
        }
        Collections.sort(answer);

        System.out.println(count);
        for (String str : answer) {
            System.out.println(str);
        }

    }
}
