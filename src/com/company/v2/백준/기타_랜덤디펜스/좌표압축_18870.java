package com.company.v2.백준.기타_랜덤디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] originNums = new int[N];
        List<Integer> copyNums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            originNums[i] = Integer.parseInt(st.nextToken());
            copyNums.add(originNums[i]);
        }

        Collections.sort(copyNums);

        Map<Integer, Integer> compressionNums = new HashMap<>();
        int rank = 0;
        for (int num : copyNums) {
            if(compressionNums.containsKey(num)) continue;
            compressionNums.put(num, rank++);
        }

        for (int num : originNums) {
            sb.append(compressionNums.get(num)).append(" ");
        }

        System.out.println(sb);
    }

}
