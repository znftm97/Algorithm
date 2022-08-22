package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int truckCnt = Integer.parseInt(st.nextToken());
        int bridgeLen = Integer.parseInt(st.nextToken());
        int bridgeMaximumWeight = Integer.parseInt(st.nextToken());
        int[] truckWeights = new int[truckCnt];
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < truckCnt; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        int nowBridgeWeight = 0;
        int time = 0;
        for (int truck : truckWeights) {
            while (true) {
                if (bridge.isEmpty()) { // 다리 비어있을 때
                    bridge.add(truck);
                    nowBridgeWeight += truck;
                    time++;
                    break;
                } else if (bridge.size() == bridgeLen) { // 트럭 다리 끝 도착
                    nowBridgeWeight -= bridge.poll();
                } else { // 다리에 트럭 추가
                    if (bridgeMaximumWeight < truck + nowBridgeWeight) { // 다음 트럭 합류시 다리 최대 하중 초과, 트럭 한칸 전진
                        bridge.add(0);
                        time++;
                    } else { // 다음 트럭 다리에 추가
                        bridge.add(truck);
                        nowBridgeWeight += truck;
                        time++;
                        break;
                    }
                }
            }
        }

        System.out.println(time + bridgeLen); // 마지막 트럭이 다리를 건너는 시간을 위해 + 다리 길이
        br.close();
    }

}
