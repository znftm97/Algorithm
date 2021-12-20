package com.company.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    static int time;
    static int mapSize;
    static int[][] map;
    static Map<Integer, String> dirMap;
    static List<int[]> snake;
    static int[] dr = {-1,0,1,0}; // 북, 동, 남, 서
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dirMap = new HashMap<>();
        snake = new ArrayList<>();
        snake.add(new int[]{1,1});
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize+1][mapSize+1];
        int appleCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1; // 값이 1이면 사과 존재
        }

        int changeDirection = Integer.parseInt(br.readLine());
        for (int i = 0; i < changeDirection; i++) {
            st = new StringTokenizer(br.readLine());
            dirMap.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        gameStart();
        System.out.println(time);
    }

    private static void gameStart() {
        int cr = 1; // 현재 행
        int cc = 1; // 현재 열
        int cd = 1; // 현재 방향

        while (true) {
            time++;
            int nr = cr + dr[cd];
            int nc = cc + dc[cd];

            if (isEnd(nr, nc)) {
                return;
            }

            if(map[nr][nc] == 1){ // 사과 있으면
                snake.add(new int[]{nr, nc});
            } else { // 사과 없으면 꼬리 삭제
                snake.add(new int[]{nr, nc});
                snake.remove(0);
            }

            cr = nr;
            cc = nc;

            String flag = dirMap.getOrDefault(time, "X");
            if(flag.equals("L")) { // 왼쪽
                cd -= 1;
                if(cd == -1) cd = 3;
            } else if(flag.equals("D")){ // 오른쪽
                cd += 1;
                cd = cd % 4;
            }
        }
    }

    public static boolean isEnd(int nr, int nc) {
        if(nr == 0 || nr > mapSize || nc == 0 || nc > mapSize){
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if(s[0] == nr && s[1] == nc) return true;
        }

        return false;
    }
}
