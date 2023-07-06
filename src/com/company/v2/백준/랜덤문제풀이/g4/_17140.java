package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _17140 {
    private static int[][] map = new int[101][101];
    private static int rCnt = 3, cCnt = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int r = 1; r <= 3; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= 3; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            if (map[targetR][targetC] == k) {
                System.out.println(time);
                return;
            }

            if (rCnt >= cCnt) calculateR();
            else calculateC();

            if (time > 100) {
                System.out.println(-1);
                return;
            }

            time++;
        }
    }

    private static void calculateR() {
        for (int r = 1; r <= 100; r++) {
            List<List<Integer>> list = new ArrayList<>();
            int[] cnts = new int[101];
            int numCnt = 0;

            for (int c = 1; c <= 100; c++) {
                if(map[r][c] == 0) continue;
                cnts[map[r][c]]++;
                numCnt++;
            }

            if (numCnt == 0) return;

            generateNumToCntArray(list, cnts);
            sort(list);
            inputR(r, list);
        }
    }

    private static void calculateC() {
        for (int c = 1; c <= 100; c++) {
            List<List<Integer>> list = new ArrayList<>();
            int[] cnts = new int[101];
            int numCnt = 0;

            for (int r = 1; r <= 100; r++) {
                if(map[r][c] == 0) continue;
                cnts[map[r][c]]++;
                numCnt++;
            }

            if (numCnt == 0) return;

            generateNumToCntArray(list, cnts);
            sort(list);
            inputC(c, list);
        }
    }


    private static void generateNumToCntArray(List<List<Integer>> list, int[] cnts) {
        for (int i = 1; i <= 100; i++) {
            if(cnts[i] == 0) continue;
            List<Integer> nums = new ArrayList<>();
            nums.add(i);
            nums.add(cnts[i]);
            list.add(nums);
        }
    }

    private static void sort(List<List<Integer>> list) {
        list.sort((o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) {
                return Integer.compare(o1.get(0), o2.get(0));
            }

            return Integer.compare(o1.get(1), o2.get(1));
        });
    }

    private static void inputR(int r, List<List<Integer>> list) {
        int c = 1;
        boolean end = false;
        Arrays.fill(map[r], 0);

        for (List<Integer> nums : list) {
            for (int num : nums) {
                if (num == 0) {
                    end = true;
                    break;
                }

                map[r][c++] = num;
            }

            if(end) break;
        }

        cCnt = Math.max(cCnt, c);
    }

    private static void inputC(int c, List<List<Integer>> list) {
        int r = 1;
        boolean end = false;
        for (int i = 1; i <= 100; i++) {
            map[i][c] = 0;
        }

        for (List<Integer> nums : list) {
            for (int num : nums) {
                if (num == 0) {
                    end = true;
                    break;
                }

                map[r++][c] = num;
            }

            if(end) break;
        }

        rCnt = Math.max(rCnt, r);
    }
}
