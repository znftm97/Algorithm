package com.company.프로그래머스.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    private static class Truck{
        int move;
        int weight;

        public Truck(int weight) {
            this.move = 1;
            this.weight = weight;
        }
    }

    public int solution(int bridgeLength, int totalBridgeWeight, int[] truck_weights) {
        Queue<Truck> trucksWait = new LinkedList<>();
        Queue<Truck> trucksOnBridge = new LinkedList<>();

        for (int w : truck_weights) {
            trucksWait.add(new Truck(w));
        }

        int nowBridgeWeight = 0;
        int result = 0;

        while (true) {
            if(trucksWait.isEmpty() && trucksOnBridge.isEmpty()) break;
            else result++;

            if (trucksOnBridge.isEmpty()) { // 다리 비어있으면 트럭 추가
                Truck truck = trucksWait.poll();
                trucksOnBridge.add(truck);
                nowBridgeWeight += truck.weight;
                continue;
            }

            for (Truck truck : trucksOnBridge) { // 다리위의 트럭 모두 한칸 이동
                truck.move++;
            }

            if (trucksOnBridge.peek().move > bridgeLength) { // 다리 제일 끝 트럭이 다리를 모두 통과한 경우
                Truck truck = trucksOnBridge.poll();
                nowBridgeWeight -= truck.weight;
            }

            if (!trucksWait.isEmpty() && totalBridgeWeight >= nowBridgeWeight + trucksWait.peek().weight) { // 무게를 초과하지 않으면 다음 트럭 추가
                Truck truck = trucksWait.poll();
                trucksOnBridge.add(truck);
                nowBridgeWeight += truck.weight;
            }
        }

        return result;
    }

}
