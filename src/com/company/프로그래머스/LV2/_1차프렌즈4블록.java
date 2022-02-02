package com.company.프로그래머스.LV2;

public class _1차프렌즈4블록 {
    private static char[][] map;
    private static int R, C = 0;
    private static boolean visit[][];
    private static final char EMPTY = 'x';

    public int solution(int r, int c, String[] board) {
        map = new char[r][c];
        R = r;
        C = c;

        for(int i = 0; i < r; i++){
            map[i] = board[i].toCharArray();
        }

        int boomBlock = 0;
        while(true){
            findAllBoom();
            int cnt = boom();
            if (cnt == 0) break;

            boomBlock += cnt;
            fallBlock();
        }

        return boomBlock;
    }

    private static void findAllBoom(){
        visit = new boolean[R][C];

        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                if (map[i][j] != EMPTY) {
                    checkBoom(i, j);
                }
            }
        }
    }

    private static void checkBoom(int r, int c){
        char block = map[r][c];

        for(int i = r ; i  < r + 2 ; ++i ) {
            for(int j = c ; j < c + 2 ; ++j) {
                if(map[i][j] != block) return;
            }
        }

        for(int i = r ; i  < r + 2 ; ++i ) {
            for(int j = c ; j < c + 2 ; ++j) {
                visit[i][j] = true;
            }
        }
    }

    private static int boom(){
        int cnt = 0;
        for(int i = 0 ; i < R ; ++i) {
            for(int j = 0 ; j < C ; ++j) {
                if(visit[i][j]) {
                    cnt++;
                    map[i][j] = EMPTY;
                }
            }
        }

        return cnt;
    }

    private static void fallBlock(){
        for (int c = 0; c < C; c++) {
            for (int r = R - 1; r >= 0; r--) {
                if (map[r][c] == EMPTY) {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != EMPTY) {
                            map[r][c] = map[nr][c];
                            map[nr][c] = EMPTY;
                            break;
                        }
                    }
                }
            }
        }
    }

}
