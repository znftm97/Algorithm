package com.company.v2.백준.랜덤문제풀이.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1202 {

    static class Gold implements Comparable<Gold>{
        int weight, value;

        public Gold(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gold g) {
            return this.weight == g.weight ?
                    Integer.compare(g.value, this.value) :
                    Integer.compare(this.weight, g.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goldCnt = Integer.parseInt(st.nextToken());
        int bagCnt = Integer.parseInt(st.nextToken());
        List<Gold> golds = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for (int i = 0; i < goldCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            golds.add(new Gold(weight, value));
        }

        for (int i = 0; i < bagCnt; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bags);
        Collections.sort(golds);
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int idx = 0;

        for (int bag : bags) {
            while (idx < goldCnt && bag >= golds.get(idx).weight) {
                pq.add(golds.get(idx++).value);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
