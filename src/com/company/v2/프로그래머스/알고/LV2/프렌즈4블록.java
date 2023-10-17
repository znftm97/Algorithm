package com.company.v2.프로그래머스.알고.LV2;

public class 프렌즈4블록 {
    static int R,C;
    static char[][] map;
    static boolean[][] removeChecks;
    static final char EMPTY = '0';
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};

    public int solution(int m, int n, String[] board) {
        R = m;
        C = n;
        map = new char[R][C];
        removeChecks = new boolean[R][C];
        int result = 0;

        for(int r = 0; r<R; r++) {
            map[r] = board[r].toCharArray();
        }

        while(true) {
            removeCheck();
            int removedBlock = remove();

            if(removedBlock == 0) {
                break;
            }

            result += removedBlock;
            fall();
            removeChecks = new boolean[R][C];
        }

        return result;
    }

    static void removeCheck() {
        for(int r = 0; r<R - 1; r++) {
            for(int c = 0; c<C - 1; c++) {
                if(map[r][c] == EMPTY) {
                    continue;
                }

                int cnt = 0;
                for(int i = 0; i<3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(map[nr][nc] == map[r][c]) {
                        cnt++;
                    }
                }

                if(cnt == 3) {
                    removeChecks[r][c] = true;
                    for(int i = 0; i<3; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        removeChecks[nr][nc] = true;
                    }
                }
            }
        }
    }

    static int remove() {
        int cnt = 0;
        for(int r = 0; r<R; r++) {
            for(int c = 0; c<C; c++) {
                if(removeChecks[r][c]) {
                    cnt++;
                    map[r][c] = EMPTY;
                }
            }
        }

        return cnt;
    }

    static void fall() {
        for(int c = 0; c<C; c++) {
            for(int r = R -1; r>0; r--) {

                if(map[r][c] == EMPTY) {
                    int nr = r;
                    while(nr >= 0) {
                        if(map[nr][c] != EMPTY) {
                            map[r][c] = map[nr][c];
                            map[nr][c] = EMPTY;
                            break;
                        }
                        nr--;
                    }
                }
            }
        }
    }
}
