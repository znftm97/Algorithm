package com.company.v2.릿코드.알고리즘.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _529 {
    private int R, C;
    private final char BOMB = 'M';
    private final char CLICK_BOMB = 'X';
    private final char OPEN_SQUARE = 'B';
    private char[][] map;
    private boolean[][] visit;
    private int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

    private static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        R = board.length;
        C = board[0].length;
        map = new char[R][C];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].clone();
        }

        int startR = click[0];
        int startC = click[1];
        visit = new boolean[R][C];

        if (board[startR][startC] == BOMB) {
            map[startR][startC] = CLICK_BOMB;
            return map;
        }

        bfs(startR, startC);
        return map;
    }

    private void bfs(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int bombCnt = 0;
            boolean hasBomb = false;
            Queue<Point> tmpQ = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc)) {
                    if (isNotVisit(nr, nc) && hasNotBomb(nr, nc) && !hasBomb) {
                        tmpQ.add(new Point(nr, nc));
                    }

                    if (hasBomb(nr, nc)) {
                        bombCnt++;
                        hasBomb = true;
                    }
                }
            }

            if (!hasBomb) {
                while (!tmpQ.isEmpty()) {
                    Point tmpP = tmpQ.poll();
                    q.add(tmpP);
                    visit[tmpP.r][tmpP.c] = true;
                }
                map[p.r][p.c] = OPEN_SQUARE;
            }

            if (bombCnt > 0) {
                map[p.r][p.c] = (char)(bombCnt + 48);
            }
        }
    }

    private boolean isInArea(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }

    private boolean hasBomb(int r, int c) {
        return map[r][c] == BOMB;
    }

    private boolean hasNotBomb(int r, int c) {
        return !hasBomb(r, c);
    }

    private boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }
}
