package com.company.v1.프로그래머스.BfsDfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) throws IOException {
        int[][] map = {{1,1}};
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qr.add(0);
        qc.add(0);

        while (!qr.isEmpty() && !qc.isEmpty()) {
            int r = qr.poll();
            int c = qc.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr <= map.length - 1 && nc <= map[0].length - 1){
                    if(map[nr][nc] == 1){
                        qr.add(nr);
                        qc.add(nc);
                        map[nr][nc] = map[r][c] + 1;
                    }
                }
            }
        }

        if (map[map.length-1][map[0].length-1] == 1) {
            System.out.println(-1);
        } else {
            System.out.println(map[map.length-1][map[0].length-1]);
        }
    }
}
