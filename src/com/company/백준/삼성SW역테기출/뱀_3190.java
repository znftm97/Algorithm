package com.company.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    private static int N, result;
    private static int nowDir = 1;
    private static int[][] map;
    private static Map<Integer, String> dirs = new HashMap<>();
    private static Deque<Point> snake = new LinkedList<>();
    private static final int APPLE = 10;

    private static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return this.r == point.r && this.c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int appleCnt = Integer.parseInt(br.readLine());
        for (int a = 0; a < appleCnt; a++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = APPLE;
        }

        int changeDirCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < changeDirCnt; i++) {
            st = new StringTokenizer(br.readLine());
            dirs.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        System.out.println(gameStart() + 1);
        br.close();
    }

    private static int gameStart(){
        Point head = new Point(0, 0);
        snake.add(head);

        while (true) {
            if(dirs.containsKey(result)){ // 방향 회전할 시간이면 회전
                changeDir();
            }

            Point beforeHead = snake.peekLast();
            Point nHead = new Point(beforeHead.r, beforeHead.c);
            move(nHead); // 머리 이동

            if (snake.contains(nHead)) { // 이동한 칸이 몸통인경우(좌표값을 비교해야 하므로 equals() 오버라이딩)
                return result;
            } else if (nHead.r < 0 || nHead.c < 0 || nHead.r >= N || nHead.c >= N) { // 이동한 칸이 벽인 경우
                return result;
            } else if (map[nHead.r][nHead.c] != APPLE) { // 이동한 칸이 사과가 아닌 경우
                snake.add(nHead);
                snake.poll(); // 꼬리도 이동
            } else if (map[nHead.r][nHead.c] == APPLE) { // 위 조건 다 통과하면, 이동한 칸에 사과가 있는 경우다. 가독성을 위해 조건 명시
                snake.add(nHead);
                map[nHead.r][nHead.c] = 0; // 사과 삭제
            }

            result++;
        }
    }

    private static void changeDir(){
        String command = dirs.get(result);
        if (command.equals("L")) {
            nowDir--;
            if (nowDir == -1) {
                nowDir = 3;
            }
        } else {
            nowDir++;
            if (nowDir == 4){
                nowDir = 0;
            }
        }
    }

    private static void move(Point nHead){
        if(nowDir == 0){ // 북
            nHead.r -= 1;
        } else if(nowDir == 1){ // 동
            nHead.c += 1;
        } else if (nowDir == 2) { // 서
            nHead.r += 1;
        } else { // 남
            nHead.c -= 1;
        }
    }

}
