package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말 {
    static int[] parents;
    static int[] ranks;
    static Set<Integer> truthPeople = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        ranks = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        if(truth == 0) {
            System.out.println(M);
            System.exit(0);
        }
        for (int i = 0; i < truth; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            for (int j = 0; j < people; j++) {
                parties.get(i).add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < parties.get(i).size() - 1; j++) {
                union(parties.get(i).get(j), parties.get(i).get(j + 1));
            }
        }

        int result = M;
        for (int i = 0; i < parties.size(); i++) {
            for (int j = 0; j < parties.get(i).size(); j++) {
                int person = parties.get(i).get(j);
                if (truthPeople.contains(find(person))) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;

        if(ranks[x] > ranks[y]) parents[x] = y;
        else parents[y] = x;

        if (truthPeople.contains(x) || truthPeople.contains(y)) {
            truthPeople.add(x);
            truthPeople.add(y);
        }

        if(ranks[x] == ranks[y]) ranks[x]++;
    }
}
