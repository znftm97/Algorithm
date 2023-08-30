package com.company.v2.프로그래머스.알고.LV2;

public class 혼자서하는틱택토 {
    static char[][] map = new char[3][3];
    static int[] dr = {-1,1,0,0,-1,1,1,-1};
    static int[] dc = {0,0,-1,1,1,1,-1,-1};

    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        for(int r = 0; r<3; r++) {
            String s = board[r];
            for(int c = 0; c<3; c++) {
                char ch = s.charAt(c);
                map[r][c] = ch;
                if(ch == 'O') oCnt++;
                else if(ch == 'X') xCnt++;
            }
        }

        boolean isOBingo = isOBingo();
        boolean isXBingo = isXBingo();

        if((isOBingo && oCnt <= xCnt) || (isXBingo && xCnt < oCnt) || (oCnt < xCnt) || (oCnt >= xCnt + 2)) {
            return 0;
        }

        return 1;
    }

    static boolean isOBingo() {
        for(int r = 0; r<3; r++) {
            for(int c = 0; c<3; c++) {
                if(map[r][c] == 'O') {
                    boolean isBingo = bfs(r,c,'O');
                    if(isBingo) return true;
                }
            }
        }

        return false;
    }

    static boolean isXBingo() {
        for(int r = 0; r<3; r++) {
            for(int c = 0; c<3; c++) {
                if(map[r][c] == 'X') {
                    boolean isBingo = bfs(r,c,'X');
                    if(isBingo) return true;
                }
            }
        }

        return false;
    }

    static boolean bfs(int r, int c, char ch) {
        for(int i = 0; i<8; i++) {
            int cnt = 1;

            while(true) {
                if(cnt == 3) return true;

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(isInArea(nr,nc) && map[nr][nc] == ch) {
                    r = nr;
                    c = nc;
                    cnt++;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    static boolean isInArea(int nr, int nc) {
        return nr >=0 && nc >= 0 && nr < 3 && nc<3;
    }
}
