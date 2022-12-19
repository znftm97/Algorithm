package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*문제에서는 0,0이 좌측아래부터지만 map을 뒤집은거랑 똑같음, 따라서 평소처럼 0,0을 좌측위로 문제 풀어도 됨*/
public class 영역구하기_2583 {
    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static List<Integer> regionCounts = new ArrayList<>();
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r;
    static int c;

    public static void bfs(Point point){
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        visit[point.r][point.c] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Point pollPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = pollPoint.r + dr[i];
                int nc = pollPoint.c + dc[i];

                if (notEscape(nr, nc) && isEmpty(nr, nc) && notVisit(nr,nc)) {
                    q.add(new Point(nr,nc));
                    visit[nr][nc] = true;
                    cnt++;
                }
            }
        }

        regionCounts.add(cnt);
    }

    public static boolean notEscape(int nr, int nc) {
        if (nr >= 0 && nc >= 0 && nr < r && nc < c) {
            return true;
        }

        return false;
    }

    public static boolean isEmpty(int nr, int nc) {
        if (map[nr][nc] == 0) {
            return true;
        }

        return false;
    }

    public static boolean notVisit(int nr, int nc) {
        if (!visit[nr][nc]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visit = new boolean[r][c];
        int squareCnt = Integer.parseInt(st.nextToken());

        for (int sc = 0; sc < squareCnt; sc++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken()) - 1; // 꼭짓점이라 1씩 감소시켜야 함
            int r2 = Integer.parseInt(st.nextToken()) - 1; // 꼭짓점이라 1씩 감소시켜야 함

            for (int i = r1; i <= r2; i++) { // 두 좌표를 잡고 드래그 했다고 생각
                for (int j = c1; j <= c2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int areaCnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    bfs(new Point(i, j));
                    areaCnt++;
                }
            }
        }

        System.out.println(areaCnt);

        Collections.sort(regionCounts);
        for (int cnt : regionCounts) {
            System.out.print(cnt + " ");
        }

        br.close();
    }

}
