package com.company.동빈북.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수얼려먹기_BFS {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int mapSizeR;
    static int mapSizeC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        mapSizeR = r;
        mapSizeC = c;
        map = new int[r][c];
        int iceCream = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 0){
                    bfs(i, j);
                    iceCream++;
                }
            }
        }

        System.out.println(iceCream);
        br.close();
    }

    public static void bfs(int r, int c) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qr.add(r);
        qc.add(c);

        while (!qr.isEmpty() && !qc.isEmpty()) {
            r = qr.poll();
            c = qc.poll();
            map[r][c] = -1;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notEscape(nr, nc) && isHole(nr, nc)) {
                    qr.add(nr);
                    qc.add(nc);
                    map[r][c] = -1;
                }
            }
        }
    }

    public static boolean notEscape(int nr, int nc){
        if(nr >= 0 && nc >= 0 && nr < mapSizeR && nc < mapSizeC){
            return true;
        }

        return false;
    }

    public static boolean isHole(int nr, int nc){
        if (map[nr][nc] == 0) {
            return true;
        }

        return false;
    }
}
