package com.company.v2.백준.기타_랜덤디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            Map<String, Integer> typeToCnt = new HashMap<>();
            int clothes = Integer.parseInt(br.readLine());

            for (int i = 0; i < clothes; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String type = st.nextToken();
                typeToCnt.put(type, typeToCnt.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (String type : typeToCnt.keySet()) {
                result *= (typeToCnt.get(type) + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }
}
