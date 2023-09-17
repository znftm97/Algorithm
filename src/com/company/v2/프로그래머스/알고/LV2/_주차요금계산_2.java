package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class _주차요금계산_2 {

    static class History implements Comparable<History> {
        String carNum;
        List<Integer> ins = new ArrayList<>();;
        List<Integer> outs = new ArrayList<>();;

        public History(String carNum) {
            this.carNum = carNum;
        }

        public void addIn(String time) {
            ins.add(timeToMinute(time));
        }

        public void addOut(String time) {
            outs.add(timeToMinute(time));
        }

        public int timeToMinute(String time) {
            String[] split = time.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

        @Override
        public int compareTo(History h) {
            return this.carNum.compareTo(h.carNum);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, History> map = new HashMap<>();

        for(String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNum = split[1];
            String command = split[2];

            if(map.containsKey(carNum)) {
                History history = map.get(carNum);
                if(command.equals("IN")) history.addIn(time);
                else history.addOut(time);
            } else {
                History history = new History(carNum);
                if(command.equals("IN")) history.addIn(time);
                else history.addOut(time);

                map.put(carNum, history);
            }
        }

        List<String> carNums = new ArrayList<>(map.keySet());
        Collections.sort(carNums);
        int[] results = new int[carNums.size()];
        int idx = 0;

        for(String carNum : carNums) {
            History his = map.get(carNum);
            int usageTime = calculateUsageTime(his.ins, his.outs);

            if(fees[0] >= usageTime) {
                results[idx++] = fees[1];
            } else {
                results[idx++] = fees[1] + (int) Math.ceil((double) (usageTime - fees[0]) / fees[2]) * fees[3];
            }
        }

        return results;
    }

    static int calculateUsageTime(List<Integer> ins, List<Integer> outs) {
        final int LAST_OUT_TIME = 1439;
        int totalTime = 0;

        for(int i = 0; i<ins.size() - 1; i++) {
            totalTime += outs.get(i) - ins.get(i);
        }

        if(ins.size() == outs.size()) {
            totalTime += outs.get(outs.size() -1) - ins.get(ins.size() - 1);
        } else {
            totalTime += LAST_OUT_TIME - ins.get(ins.size() - 1);
        }

        return totalTime;
    }
}
