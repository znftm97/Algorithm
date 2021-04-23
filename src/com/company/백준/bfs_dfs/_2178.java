package com.company.백준.bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    static int mapSizeX, mapSizeY;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        mapSizeX = Integer.parseInt(st.nextToken());
        mapSizeY = Integer.parseInt(st.nextToken());
        map = new int[mapSizeX][mapSizeY];
        visit = new boolean[mapSizeX][mapSizeY];

        for (int i = 0; i < mapSizeX; i++) {
            String s = br.readLine();
            for (int j = 0; j < mapSizeY; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0); // (0,0)에서 출발

        System.out.println(map[mapSizeX-1][mapSizeY-1]); // 배열은 0부터니까 1 빼줘야함
    }

    private static void bfs(int x, int y) {
        /* Queue<int []> 처럼 int형 배열을 요소로 하는 큐를 하나 생성해서 각 배열에 x,y값을 저장하는 방법과 (2667 문제 풀이 참고)
        *  Queue<Integer> 를 두개 생성해서 x,y값을 각 큐로 저장하는 방법 2가지 존재
        * */
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);

        while (!qx.isEmpty() && !qy.isEmpty()) {
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true; // 방문한 좌표 표시

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < mapSizeX && 0 <= ny && ny < mapSizeY) {
                    if (map[nx][ny] == 1 && visit[nx][ny] == false) { // 새로 구한 좌표이 1이고 방문 안한경우
                        qx.add(nx);
                        qy.add(ny);
                        visit[nx][ny] = true;
                        map[nx][ny] = map[x][y]+1; // 새로 구한 좌표의 값을, 기존 좌표값에 +1 -> 최종적으로 거쳐간 좌표의 개수가 됨
                    }
                }
            }
        }
    }

}
