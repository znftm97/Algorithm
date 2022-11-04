package com.company.v2.코드트리.프로그래밍연습.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좌우로_움직이는_로봇 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] robotAPos = new int[1000001];
        int[] robotBPos = new int[1000001];
        int idxA = 1;
        int idxB = 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            for (int j = 0; j < time; j++) {
                if (command.equals("L")) {
                    robotAPos[idxA] = robotAPos[idxA - 1] - 1;
                } else {
                    robotAPos[idxA] = robotAPos[idxA - 1] + 1;
                }

                idxA++;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            for (int j = 0; j < time; j++) {
                if (command.equals("L")) {
                    robotBPos[idxB] = robotBPos[idxB - 1] - 1;
                } else {
                    robotBPos[idxB] = robotBPos[idxB - 1] + 1;
                }

                idxB++;
            }
        }

        int result = 0;
        if(idxA < idxB) {
            for(int i = idxA; i < idxB; i++) {
                robotAPos[i] = robotAPos[i - 1];
            }
        }
        else if(idxA > idxB) {
            for(int i = idxB; i < idxA; i++) {
                robotBPos[i] = robotBPos[i - 1];
            }
        }

        int maxIdx = 0;
        if(idxA < idxB){
            maxIdx = idxB;
        } else{
            maxIdx = idxA;
        }

        for(int i = 1; i < maxIdx; i++) {
            if (robotAPos[i] == robotBPos[i] && robotAPos[i - 1] != robotBPos[i - 1]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
