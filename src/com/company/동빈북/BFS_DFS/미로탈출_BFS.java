package com.company.동빈북.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출_BFS {
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
        map = new int[r + 1][c + 1];
        mapSizeR = r;
        mapSizeC = c;

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1,1);
        System.out.println(map[r][c]);
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

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                if (notEscape(nr, nc) && notMonster(nr, nc)) {
                    qr.add(nr);
                    qc.add(nc);
                    map[nr][nc] = map[r][c] + 1;
                }
            }
        }
    }

    public static boolean notEscape(int nr, int nc){
        if(nr >= 1 && nc >= 1 && nr <= mapSizeR && nc <= mapSizeC){
            return true;
        }

        return false;
    }

    public static boolean notMonster(int nr, int nc){
        if (map[nr][nc] == 1) {
            return true;
        }

        return false;
    }

}
