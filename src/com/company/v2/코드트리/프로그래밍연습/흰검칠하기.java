package com.company.v2.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 흰검칠하기 {
    private static final int WHITE = 111;
    private static final int BLACK = 222;
    private static final int GRAY = 333;
    private static final int MAX = 100000;

    private static class Info {

        private int leftIdx;
        private int rightIdx;
        private int color;

        public Info(int leftIdx, int rightIdx, int color) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
            this.color = color;
        }

        private static Info of(int leftIdx, int rightIdx, int color) {
            return new Info(leftIdx, rightIdx, color);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Info> infos = new ArrayList<>();
        int[] checked = new int[MAX * 2 + 10]; // 타일 색칠
        int[][] whiteBlackCnt = new int[MAX * 2 + 10][2]; // 흰색, 검은색 타일 카운팅
        int curIdx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            if (command.equals("L")) {
                move -= 1; // 뒤집은 타일 위치에 존재함, 즉 move=1 이면 이동하지 않음
                infos.add(Info.of(curIdx - move, curIdx, WHITE));
                curIdx -= move;
            } else {
                move -= 1;
                infos.add(Info.of(curIdx, curIdx + move, BLACK));
                curIdx += move ;
            }

            Info info = infos.get(infos.size() - 1);
            info.leftIdx += MAX; // 인덱스값이 음수가 나오지 않도록 최대값 더해줌
            info.rightIdx += MAX;
        }

        for (Info info : infos) {
            for (int i = info.leftIdx; i <= info.rightIdx; i++) {
                if(checked[i] == GRAY) continue;

                if (info.color == WHITE) {
                    checked[i] = WHITE;
                    whiteBlackCnt[i][0]++;
                } else if (info.color == BLACK) {
                    checked[i] = BLACK;
                    whiteBlackCnt[i][1]++;
                }

                if (whiteBlackCnt[i][0] >= 2 && whiteBlackCnt[i][1] >= 2) {
                    checked[i] = GRAY;
                }
            }
        }

        int whiteCnt = 0;
        int blackCnt = 0;
        int grayCnt = 0;

        for (int i = 0; i < checked.length; i++) {
            if (checked[i] == WHITE) {
                whiteCnt++;
            } else if (checked[i] == BLACK) {
                blackCnt++;
            } else if (checked[i] == GRAY) {
                grayCnt++;
            }
        }

        System.out.println(whiteCnt + " " + blackCnt + " " + grayCnt);
    }

}
