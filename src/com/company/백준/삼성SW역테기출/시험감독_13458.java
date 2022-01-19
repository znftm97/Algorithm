package com.company.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 시험감독_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int roomCnt = Integer.parseInt(br.readLine());
        long[] people = new long[roomCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < roomCnt; i++) {
            people[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long mainDirector = Long.parseLong(st.nextToken());
        long subDirector = Long.parseLong(st.nextToken());
        long result = 0;

        for (int i = 0; i < roomCnt; i++) {
            long personnel = people[i];
            personnel -= mainDirector; // 일단 총감독은 무조건 1명포함
            result++;

            if(personnel > 0) { // 인원이 남아있으면
                long needDirector = personnel / subDirector;
                if(personnel % subDirector == 0) result += needDirector; // 남은 인원을 부감독으로 나눴을 때 나눠떨어지면 몫만큼
                else result += needDirector + 1L; // 딱 안나눠 떨어지면 나머지 인원들 감시하기위한 부감독 한명 추
            }
        }

        System.out.println(result);
        br.close();
    }
}
