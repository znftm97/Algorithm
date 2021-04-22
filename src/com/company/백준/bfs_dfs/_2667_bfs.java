package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2667_bfs {
    static int mapSize; // 지도의 크기
    static int[][] map; // 지도
    static int houseCount; // 한 단지에 존재하는 집의 개수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];

        //지도에 자료 입력
        for (int i = 0; i < mapSize; i++) {
            String s = br.readLine();

            for (int j = 0; j < mapSize; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int totalCount = 0; // 단지의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 각 단지에 존재하는 집의 개수를 저장(오름차순으로 출력하기 때문에 우선순위 큐 사용)

        /*한 좌표씩 조회하면서 1일경우 dfs 호출하고, 한 단지를 모두 조회 후(재귀호출을 탈출 후) 다시 한 좌표씩 조회*/
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == 1) {
                    // 조회하다가 좌표가 1일때 즉 첫 단지를 발견했을 경우이므로, houseCount(집의 개수) 초기화 및 totalCount(단지의 개수) 증감
                    houseCount = 0;
                    totalCount++;

                    bfs(i, j); // 한 좌표씩 조회해서 좌표가 1일때 dfs 호출
                    pq.add(houseCount); // 한 단지의 조회가 끝나서 재귀호출에서 빠져 나온 후, 한 단지에 존해나느 집의개수를 큐에 추가
                }
            }
        }

        sb.append(totalCount).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>(); // int 배열을 요소로 하는 Queue 생성
        houseCount = 0;
        q.add(new int[] {x,y}); // 파라미터로 전달된 좌표를 기준으로 새 배열 생성해서 큐에 추가
        map[x][y] = 0; // 조회한 좌표를 지도에서 0으로 초기화, 그래야 해당 좌표를 다시 조회하지 않음

        while (!q.isEmpty()) {
            int curX = q.peek()[0]; // 현재 좌표의 x값
            int curY = q.peek()[1]; // 현재 좌표의 y값
            q.poll(); // 큐에서 제거
            houseCount++;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i]; // dx 배열의 -1, 1, 0, 0 값을 차례대로 넣고, 현재 좌표의 x값과 더해 nx 생성
                int ny = curY + dy[i]; // dy 배열의 0, 0, -1, 1 값을 차례대로 넣고, 현재 좌표의 y값과 더해 ny 생성

                if (0 <= nx && nx < mapSize && 0 <= ny && ny < mapSize) {
                    if (map[nx][ny] == 1) { // 새로 구한 좌표값(상,하,좌,우)이 1이면 조회를 안한 좌표이므로(조회한 좌표는 위에서 0으로 초기화했으므로) 다시 dfs 호출출
                        q.add(new int[] {nx,ny});
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

}
