package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> plusNums = new ArrayList<>();
        List<Integer> minusNums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) plusNums.add(num);
            else minusNums.add(num);
        }

        Collections.sort(minusNums);
        Collections.sort(plusNums, Collections.reverseOrder());

        int sum = 0;
        int index = 0;
        while (index < minusNums.size()) {
            if (index < minusNums.size() - 1) {
                sum += minusNums.get(index) * minusNums.get(index + 1);
                index += 2;
            } else {
                sum += minusNums.get(index++);
            }
        }

        index = 0;
        while (index < plusNums.size()) {
            if (index < plusNums.size() - 1 && plusNums.get(index) != 1 && plusNums.get(index + 1) != 1) {
                sum += plusNums.get(index) * plusNums.get(index + 1);
                index += 2;
            } else {
                sum += plusNums.get(index++);
            }
        }

        System.out.println(sum);
        br.close();
    }

}
