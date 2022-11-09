package com.company.v2.코드트리.프로그래밍연습.완탐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 상해버린_치즈 {
    private static class History{
        int personId;
        int cheeseId;
        int ateTime;

        public History(int personId, int cheeseId, int ateTime) {
            this.personId = personId;
            this.cheeseId = cheeseId;
            this.ateTime = ateTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int cheeseCnt = Integer.parseInt(st.nextToken());
        int historyCnt = Integer.parseInt(st.nextToken());
        int sickCnt = Integer.parseInt(st.nextToken());

        int[][] sicks = new int[sickCnt][2];
        List<Integer> ableExpiredCheeseIds = new ArrayList<>(); // 상한 가능성이 있는 치즈들
        List<History> totalHistories = new ArrayList<>(); // 전체 기록
        List<History> filteredHistories = new ArrayList<>(); // 아픈 사람들의 기록

        // 입력
        for (int i = 0; i < historyCnt; i++) {
            st = new StringTokenizer(br.readLine());
            totalHistories.add(new History(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < sickCnt; i++) {
            st = new StringTokenizer(br.readLine());
            sicks[i][0] = Integer.parseInt(st.nextToken());
            sicks[i][1] = Integer.parseInt(st.nextToken());
        }

        // 아픈 사람들 기록만 필터링
        for (int i = 0; i < sickCnt; i++) {
            int personId = sicks[i][0];
            int sickTime = sicks[i][1];

            for (History history : totalHistories) {
                if (history.personId == personId && history.ateTime < sickTime) { // 아프기 전에 먹은 치즈는 상했을 수 있음
                    filteredHistories.add(history);
                }
            }
        }

        // 상한 가능성 있는 치즈 선별 (== 모든 아픈 사람이 먹은 치즈)
        int[] tmp = new int[cheeseCnt + 1];
        for (History history : filteredHistories) {
            tmp[history.cheeseId]++;
        }

        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] >= sickCnt) {
                ableExpiredCheeseIds.add(i);
            }
        }

        // 필터링된 상한 치즈 하나씩 골라서, 상한 치즈 먹은 사람 구하고 그 중 최대값 추출
        int maxMedicine = 0;
        boolean[] alreadyGetMedicine = new boolean[people + 1]; // 같은 사람이 약 여러번 받는 상황 제외
        for (int expiredCheeseId : ableExpiredCheeseIds) {
            int medicine = 0;

            for (History history : totalHistories) {
                if (history.cheeseId == expiredCheeseId && !alreadyGetMedicine[history.personId]) {
                    alreadyGetMedicine[history.personId] = true;
                    medicine++;
                }
            }

            maxMedicine = Math.max(maxMedicine, medicine);
        }

        System.out.println(maxMedicine);
    }

}
