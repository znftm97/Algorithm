package com.company.v2.코드트리.LV4.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class K번_최대값으로_이동하기 {
    private static int N, K, maxR, maxC;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        maxR = Integer.parseInt(st.nextToken()) - 1;
        maxC = Integer.parseInt(st.nextToken()) - 1;

        for (int k = 0; k < K; k++) {
            if (bfs(maxR, maxC)) {
                break;
            }
        }

        maxR++;
        maxC++;
        System.out.println(maxR + " " + maxC);
    }

    private static boolean bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        visit = new boolean[N][N];
        visit[r][c] = true;

        boolean isFinish = true;
        int max = 0;
        int startVal = map[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];

                if (isAbleArea(nr, nc) && isSmaller(startVal, nr, nc) && isNotVisited(nr, nc)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;

                    if (max < map[nr][nc]) { // 최대값 갱신
                        max = map[nr][nc];
                        maxR = nr;
                        maxC = nc;
                        isFinish = false;
                    } else if (max == map[nr][nc]) { // 최대값이랑 같으면
                        if (nr == maxR) { // 행이 같으면, 열이 작은곳으로
                            maxC = Math.min(maxC, nc);
                        } else { // 행이 다르면 행이 작은 곳으로
                            if (maxR > nr) {
                                maxR = nr;
                                maxC = nc;
                            }
                        }
                        isFinish = false;
                    }
                }
            }
        }

        return isFinish;
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean isSmaller(int startVal, int nr, int nc) {
        return map[nr][nc] < startVal;
    }

    private static boolean isNotVisited(int r, int c) {
        return !visit[r][c];
    }

}
