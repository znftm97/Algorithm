package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16235 {
    private static class Tree implements Comparable<Tree>{
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    private static int[][] addEnergys;
    private static int[][] nowEnergys;
    private static Queue<Tree> trees = new PriorityQueue<>();
    private static Queue<Tree> deadTrees = new LinkedList<>();
    private static int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
    private static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int treeCnt = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        addEnergys = new int[N + 1][N + 1];
        nowEnergys = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                addEnergys[r][c] = Integer.parseInt(st.nextToken());
                nowEnergys[r][c] = 5;
            }
        }

        for (int i = 0; i < treeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c, age));
        }

        while (year > 0) {
            spring();
            summer();
            fall();
            winter();

            year--;
        }

        System.out.println(trees.size());
    }

    private static void spring() {
        Queue<Tree> tmpQ = new LinkedList<>();
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            if (tree.age > nowEnergys[tree.r][tree.c]) {
                deadTrees.add(tree);
            } else {
                nowEnergys[tree.r][tree.c] -= tree.age;
                tree.age++;
                tmpQ.add(tree);
            }
        }
        trees.addAll(tmpQ);
    }

    private static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();
            nowEnergys[tree.r][tree.c] += tree.age / 2;
        }
    }

    private static void fall() {
        Queue<Tree> addQ = new LinkedList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = tree.r + dr[i];
                    int nc = tree.c + dc[i];
                    if (isInArea(nr, nc)) {
                        addQ.add(new Tree(nr, nc, 1));
                    }
                }
            }
        }
        trees.addAll(addQ);
    }

    private static void winter() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                nowEnergys[r][c] += addEnergys[r][c];
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }
}
