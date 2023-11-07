package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17135 {
    static int[][] map;
    static int R,C,DIST,result;
    static final int ARCHER = 10;
    static List<Enemy> enemies = new ArrayList<>();

    static class Enemy implements Comparable<Enemy> {
        int r,c,dist;

        public Enemy(int r, int c, int dist) {
            this.r=r;
            this.c=c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Enemy e) {
            if(this.dist == e.dist) {
                return Integer.compare(this.c, e.c);
            }

            return Integer.compare(this.dist, e.dist);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Enemy)) return false;

            Enemy enemy = (Enemy) o;
            if (r != enemy.r) return false;
            return c == enemy.c;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + c;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        DIST = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C];

        for(int r = 0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c<C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1) {
                    enemies.add(new Enemy(r,c,0));
                }
            }
        }

        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        if(depth == 3) {
            result = Math.max(result, startGame());
            return;
        }

        for (int i = start; i < C; i++) {
            map[R][i] = ARCHER;
            dfs(depth + 1, i + 1);
            map[R][i] = 0;
        }
    }

    static int startGame() {
        List<Enemy> copyEnemies = new ArrayList<>();
        for (Enemy e : enemies) {
            copyEnemies.add(new Enemy(e.r, e.c, e.dist));
        }

        int cnt = 0;
        for(int i = 0; i<R; i++) {
            cnt += attack(copyEnemies);
            down(copyEnemies);

            if(copyEnemies.isEmpty()) {
                break;
            }
        }
        return cnt;
    }

    static void down(List<Enemy> copyEnemies) {
        Set<Enemy> removeEnemy = new HashSet<>();
        for(Enemy e : copyEnemies) {
            e.r += 1;
            if(e.r == R) {
                removeEnemy.add(e);
            }
        }

        copyEnemies.removeAll(removeEnemy);
    }

    static int attack(List<Enemy> copyEnemies) {
        Set<Enemy> canAttackEnemies = new HashSet<>();
        for(int c = 0; c<C; c++) {
            if(map[R][c] != ARCHER) {
                continue;
            }

            Queue<Enemy> pq = new PriorityQueue<>();
            for(Enemy e : copyEnemies) {
                int dist = Math.abs(R - e.r) + Math.abs(c - e.c);
                if(dist <= DIST) {
                    pq.add(new Enemy(e.r, e.c, dist));
                }
            }

            if (!pq.isEmpty()) {
                canAttackEnemies.add(pq.poll());
            }
        }

        copyEnemies.removeAll(canAttackEnemies);

        return canAttackEnemies.size();
    }
}
