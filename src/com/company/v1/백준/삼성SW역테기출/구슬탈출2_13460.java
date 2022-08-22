package com.company.v1.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
    private static int R, C;
    private static char[][] map;
    private static boolean[][][][] visit;
    private static Point redPoint, bluePoint;
    private static int result = -1;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    private static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C][R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'R') redPoint = new Point(i, j,0);
                else if(map[i][j] == 'B') bluePoint = new Point(i, j,0);
            }
        }

        bfs(redPoint, bluePoint);
        System.out.println(result);
        br.close();
    }

    private static void bfs(Point redPoint, Point bluePoint) {
        Queue<Point> redQ = new LinkedList<>();
        Queue<Point> blueQ = new LinkedList<>();
        redQ.add(redPoint);
        blueQ.add(bluePoint);
        visit[redPoint.r][redPoint.c][bluePoint.r][bluePoint.c] = true;

        while (!redQ.isEmpty() && !blueQ.isEmpty()) {
            Point nRedPoint = redQ.poll();
            Point nBluePoint = blueQ.poll();

            if(nRedPoint.cnt > 10){
                result = -1;
                return;
            }

            if (map[nBluePoint.r][nBluePoint.c] == 'O') {
                continue;
            }

            if (map[nRedPoint.r][nRedPoint.c] == 'O') {
                result = nRedPoint.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {

                // 빨간 구슬 굴리기
                int redNR = nRedPoint.r;
                int redNC = nRedPoint.c;
                while (true) {
                    redNR += dr[i];
                    redNC += dc[i];

                    if(map[redNR][redNC] == 'O') break; // 기울이다 구멍 만나면 break
                    else if (map[redNR][redNC] == '#'){ // 기울이다 벽 만나면, 한칸 뒤로 빼고 break
                        redNR -= dr[i];
                        redNC -= dc[i];
                        break;
                    }
                }

                // 파란 구슬 굴리기
                int blueNR = nBluePoint.r;
                int blueNC = nBluePoint.c;
                while (true) {
                    blueNR += dr[i];
                    blueNC += dc[i];

                    if(map[blueNR][blueNC] == 'O') break;
                    else if (map[blueNR][blueNC] == '#'){
                        blueNR -= dr[i];
                        blueNC -= dc[i];
                        break;
                    }
                }

                // 굴렸는데 두 구슬이 위치가 같고 && 구멍이 아닌경우
                if (redNR == blueNR && redNC == blueNC && map[redNR][redNC] != 'O') {
                    // 각 구슬이 이동한 거리 계산
                    int redDistance = Math.abs(redNR - nRedPoint.r) + Math.abs(redNC - nRedPoint.c);
                    int blueDistance = Math.abs(blueNR - nBluePoint.r) + Math.abs(blueNC - nBluePoint.c);

                    // 더 많이 이동한 구슬이 뒤에있던 구슬이므로 한칸 뒤로
                    if (redDistance > blueDistance) {
                        redNR -= dr[i];
                        redNC -= dc[i];
                    } else {
                        blueNR -= dr[i];
                        blueNC -= dc[i];
                    }
                }

                // 이동 처리
                if (!visit[redNR][redNC][blueNR][blueNC]) {
                    redQ.add(new Point(redNR, redNC, nRedPoint.cnt + 1));
                    blueQ.add(new Point(blueNR, blueNC, nBluePoint.cnt + 1));
                    visit[redNR][redNC][blueNR][blueNC] = true;
                }
            }
        }
    }

}
