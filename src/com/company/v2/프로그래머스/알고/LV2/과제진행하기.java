package com.company.v2.프로그래머스.알고.LV2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 과제진행하기 {
    private static class Work implements Comparable<Work> {
        String name;
        int startTime;
        int workTime;

        public Work(String name, String startTime, String workTime){
            this.name=name;
            this.workTime=Integer.parseInt(workTime);

            int hour = Integer.parseInt(startTime.substring(0,2));
            int minute = Integer.parseInt(startTime.substring(3,5));
            this.startTime = hour * 60 + minute;
        }

        public int getFinishTime() {
            return this.startTime + this.workTime;
        }

        @Override
        public int compareTo(Work w){
            return Integer.compare(this.startTime, w.startTime);
        }
    }

    public String[] solution(String[][] plans) {
        Queue<Work> works = new PriorityQueue<>();
        Stack<Work> stopWorks = new Stack<>();
        String[] results = new String[plans.length];
        int resultIdx = 0;

        for(String[] plan : plans){
            works.add(new Work(plan[0], plan[1], plan[2]));
        }

        while(!works.isEmpty()){
            Work nowWork = works.poll();

            if(!works.isEmpty()){
                Work nextWork = works.peek();

                if (nowWork.getFinishTime() == nextWork.startTime) { // 현재 작업 끝나는시간이, 다음 작업 시작시간이 같은 경우
                    results[resultIdx++] = nowWork.name;
                } else if (nowWork.getFinishTime() > nextWork.startTime) { // 다음 작업 시작시간까지, 현재 작업을 못끝내는 경우
                    nowWork.workTime -= nextWork.startTime - nowWork.startTime;
                    stopWorks.push(nowWork);
                } else { // 다음 작업 시작시간까지, 시간이 남는 경우
                    results[resultIdx++] = nowWork.name;
                    int currentTime = nowWork.getFinishTime();

                    while (!stopWorks.isEmpty()) {
                        Work stopWork = stopWorks.pop();

                        if (currentTime + stopWork.workTime <= nextWork.startTime) {
                            results[resultIdx++] = stopWork.name;
                            currentTime += stopWork.workTime;
                        } else {
                            stopWork.workTime -= nextWork.startTime - currentTime;
                            stopWorks.push(stopWork);
                            break;
                        }
                    }
                }

                continue;
            }

            results[resultIdx++] = nowWork.name;
            while (!stopWorks.isEmpty()) {
                results[resultIdx++] = stopWorks.pop().name;
            }

        }

        return results;
    }
}
