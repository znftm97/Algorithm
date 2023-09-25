package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17140_2 {
    static int R,C;
    static int[][] map = new int[101][101];

    static class Number implements Comparable<Number>{
        int num, cnt;

        public Number(int num, int cnt) {
            this.num=num;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Number n) {
            if(this.cnt == n.cnt) {
                return Integer.compare(this.num, n.num);
            }

            return Integer.compare(this.cnt, n.cnt);
        }
    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        R = 3;
        C = 3;

        for(int r = 1; r<=3; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c<=3; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        for(int i = 0; i <= 100; i++) {
            if(map[targetR][targetC] == target) {
                result = i;
                break;
            }

            if(R >= C) rowSort();
            else colSort();
        }

        System.out.println(result);
    }

    static void rowSort() {
        for(int r = 1; r<=100; r++) {
            Map<Integer, Integer> numsToCntMap = new HashMap<>();
            List<Number> nums = new ArrayList<>();

            for(int c = 1; c<=100; c++) {
                if(map[r][c] == 0) continue;
                numsToCntMap.put(map[r][c], numsToCntMap.getOrDefault(map[r][c], 0) + 1);
            }
            if(numsToCntMap.isEmpty()) return;

            for(int num : numsToCntMap.keySet()) {
                nums.add(new Number(num, numsToCntMap.get(num)));
            }

            Collections.sort(nums);
            Arrays.fill(map[r], 0);

            int c = 1;
            for(Number number : nums) {
                if(c >= 100) break;
                map[r][c++] = number.num;
                map[r][c++] = number.cnt;
            }

            C = Math.max(C, c - 1);
        }

    }

    static void colSort() {
        for(int c = 1; c<=100; c++) {
            Map<Integer, Integer> numsToCntMap = new HashMap<>();
            List<Number> nums = new ArrayList<>();

            for(int r = 1; r<=100; r++) {
                if(map[r][c] == 0) continue;
                numsToCntMap.put(map[r][c], numsToCntMap.getOrDefault(map[r][c], 0) + 1);
            }
            if(numsToCntMap.isEmpty()) return;

            for(int num : numsToCntMap.keySet()) {
                nums.add(new Number(num, numsToCntMap.get(num)));
            }

            Collections.sort(nums);
            for (int i = 1; i <= 100; i++) {
                map[i][c] = 0;
            }

            int r = 1;
            for(Number number : nums) {
                if(r >= 100) break;
                map[r++][c] = number.num;
                map[r++][c] = number.cnt;
            }

            R = Math.max(R, r - 1);
        }

    }
}
