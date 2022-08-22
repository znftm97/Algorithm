package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static int[][] originMap;
    static int[][] wallMap;
    static int N,M;
    static ArrayList<virusPoint> virusList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafeAreaCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        virusList = new ArrayList<>();

        /*map 입력 및 바이러스 있는 영역 좌표 저장*/
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if (originMap[i][j] == 2) virusList.add(new virusPoint(i,j));
            }
        }

        wallMap = copy(originMap); // 벽을 세우기 위한 맵을 복사
        makeWall(0); // 벽 세우기
        System.out.println(maxSafeAreaCount);
    }

    static class virusPoint{
        int x;
        int y;

        public virusPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] copy(int[][] map) {
        int[][] tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }

    public static void makeWall(int wallCount) {
        if (wallCount == 3) { // 벽이 3개 세워지면 바이러스 감염 시작
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (wallMap[i][j] == 0) {
                    wallMap[i][j] = 1; // 벽 세우기
                    makeWall(wallCount + 1); // 재귀호출
                    wallMap[i][j] = 0; // 벽 다시 제거
                }
            }
        }
    }

    public static void spreadVirus() {
        int[][] copyWallMap = copy(wallMap);

        Queue<virusPoint> vq = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            vq.add(new virusPoint(virusList.get(i).x, virusList.get(i).y));
        }

        while (!vq.isEmpty()) {
            virusPoint poll = vq.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 맵에서 벗어나는지 검사
                    if (copyWallMap[nx][ny] == 0) { // 새 좌표값이 빈칸인지 검사
                        copyWallMap[nx][ny] = 2; // 바이러스 감염
                        vq.add(new virusPoint(nx, ny)); // 큐에 추가
                    }
                }
            }
        }

        int safeAreaCount = checkSafeArea(copyWallMap);
        maxSafeAreaCount = Math.max(maxSafeAreaCount, safeAreaCount);
    }

    static public int checkSafeArea(int[][] copyWallMap) {
        int safeAreaCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyWallMap[i][j] == 0) {
                    safeAreaCount++;
                }
            }
        }

        return safeAreaCount;
    }
}
