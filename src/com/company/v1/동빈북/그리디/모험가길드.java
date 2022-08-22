package com.company.v1.동빈북.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모험가길드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] adventurers = new int[n];
        int numberOfPeople = 0;
        int totalGroupCount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            adventurers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(adventurers);

        for (int i = 0; i < n; i++) {
            numberOfPeople += 1;
            if(numberOfPeople >= adventurers[i]){
                totalGroupCount++;
                numberOfPeople = 0;
            }
        }

        System.out.println(totalGroupCount);
    }

}
