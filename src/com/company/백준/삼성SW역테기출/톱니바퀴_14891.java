package com.company.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
    private static int[][] gears = new int[4][8];
    private static int[] spins; // 회전할 톱니바퀴들의 방향 저장, 0이면 회전안함
    private static final int MEET_RIGHT = 2;
    private static final int MEET_LEFT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(split[j]);
            }
        }

        int spinCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < spinCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            spins = new int[4];

            checkSpin(gearNum, dir); // 케이스마다 회전할 톱니바퀴들 체크
            spin();
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) { // S극인경우
                if(i == 0) sum++;
                else if(i == 1) sum += 2;
                else if(i == 2) sum += 4;
                else if(i == 3) sum += 8;
            }
        }

        System.out.println(sum);
        br.close();
    }

    private static void checkSpin(int gearNum, int dir) {
        spins[gearNum] = dir;
        int leftGearNum = gearNum - 1;
        int rightGearNum = gearNum + 1;

        if(isSpinOfLeft(leftGearNum, gearNum, dir)){
            checkSpin(leftGearNum, dir * -1);
        }

        if(isSpinOfRight(rightGearNum, gearNum, dir)){
            checkSpin(rightGearNum, dir * -1);
        }
    }

    private static boolean isSpinOfLeft(int leftGearNum, int gearNum, int dir){
        if (leftGearNum >= 0 && spins[leftGearNum] == 0) {
            if(gears[leftGearNum][MEET_RIGHT] != gears[gearNum][MEET_LEFT]){ // N극 S극인경우
                return true;
            }
        }

        return false;
    }

    private static boolean isSpinOfRight(int rightGearNum, int gearNum, int dir){
        if (rightGearNum <= 3 && spins[rightGearNum] == 0) {
            if (gears[rightGearNum][MEET_LEFT] != gears[gearNum][MEET_RIGHT]) { // N극 S극인경우
                return true;
            }
        }

        return false;
    }


    private static void spin(){
        for (int i = 0; i < 4; i++) {
            if(spins[i] == 1){
                int tmp = gears[i][7];

                for (int j = 7; j > 0; j--) {
                    gears[i][j] = gears[i][j-1];
                }

                gears[i][0] = tmp;

            } else if(spins[i] == -1){
                int tmp = gears[i][0];

                for (int j = 0; j < 7; j++) {
                    gears[i][j] = gears[i][j + 1];
                }

                gears[i][7] = tmp;
            }
        }
    }

}
