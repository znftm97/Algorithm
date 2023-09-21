package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16235_2 {
    private static int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
    private static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[][] originEnergies;
    static int[][] energies;
    static Queue<Tree> trees = new PriorityQueue<>();
    static Queue<Tree> deadTrees = new LinkedList<>();
    static int N;

    static class Tree implements Comparable<Tree> {
        int r,c,age;

        public Tree(int r, int c, int age) {
            this.r=r;
            this.c=c;
            this.age=age;
        }

        @Override
        public int compareTo(Tree t) {
            return Integer.compare(this.age, t.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        originEnergies = new int[N + 1][N + 1];
        energies = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            Arrays.fill(energies[r], 5);
        }

        for(int r = 1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c<=N; c++) {
                originEnergies[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c, age));
        }

        for (int y = 0; y < year; y++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    static void spring() {
        Queue<Tree> tmpQ = new LinkedList<>();
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            if (tree.age > energies[tree.r][tree.c]) {
                deadTrees.add(tree);
            } else {
                energies[tree.r][tree.c] -= tree.age;
                tree.age++;
                tmpQ.add(tree);
            }
        }
        trees.addAll(tmpQ);
    }

    static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();
            energies[tree.r][tree.c] += tree.age / 2;
        }
    }

    static void fall() {
        List<Tree> newTrees = new ArrayList<>();
        for(Tree tree : trees) {
            if(tree.age % 5 == 0) {
                for(int i = 0; i<8; i++) {
                    int nr = tree.r + dr[i];
                    int nc = tree.c + dc[i];

                    if (nr >= 1 && nc >= 1 && nr <= N && nc <= N) {
                        newTrees.add(new Tree(nr, nc, 1));
                    }
                }
            }
        }

        trees.addAll(newTrees);
    }

    static void winter() {
        for(int r= 1; r<=N; r++) {
            for(int c= 1; c<=N; c++) {
                energies[r][c] += originEnergies[r][c];
            }
        }
    }
}
