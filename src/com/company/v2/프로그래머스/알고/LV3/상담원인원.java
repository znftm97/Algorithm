package com.company.v2.프로그래머스.알고.LV3;

import java.util.*;

public class 상담원인원 {
    static class Info implements Comparable<Info> {
        int type, mentorCnt, waitTime, waitTimeWhenAddMentor;
        List<Meet> meets = new ArrayList<>();

        public Info(int type, Meet meet) {
            this.type = type;
            this.mentorCnt = 1;
            meets.add(meet);
        }

        @Override
        public int compareTo(Info i) {
            return Integer.compare(i.waitTime - i.waitTimeWhenAddMentor, this.waitTime - this.waitTimeWhenAddMentor);
        }

        public void calculateWaitTime() {
            int waitTime = 0;
            int now = meets.get(0).endTime;

            for(int i = 1; i<meets.size(); i++) {
                Meet meet = meets.get(i);
                if(now > meet.startTime) {
                    waitTime += now - meet.startTime;
                    now += meet.meetTime;
                } else {
                    now = meet.endTime;
                }
            }

            this.waitTime = waitTime;
        }

        public void calculateWaitTimeWithMentor() {
            int mentorCnt = this.mentorCnt + 1;
            int waitTimeWhenAddMentor = 0;
            Queue<Integer> pq = new PriorityQueue<>();
            pq.add(meets.get(0).endTime);
            mentorCnt--;

            for(int i = 1; i<meets.size(); i++) {
                Meet meet = meets.get(i);
                if(mentorCnt > 0) {
                    pq.add(meet.endTime);
                    mentorCnt--;
                } else {
                    int now = pq.poll();
                    if(now > meet.startTime) {
                        waitTimeWhenAddMentor += now - meet.startTime;
                        pq.add(now + meet.meetTime);
                    } else {
                        pq.add(meet.endTime);
                    }
                }
            }

            this.waitTimeWhenAddMentor = waitTimeWhenAddMentor;
        }
    }

    static class Meet {
        int startTime;
        int meetTime;
        int endTime;

        public Meet(int startTime, int meetTime) {
            this.startTime = startTime;
            this.meetTime = meetTime;
            this.endTime = startTime + meetTime;
        }
    }

    public int solution(int k, int n, int[][] reqs) {
        Map<Integer, Info> map = new HashMap<>();
        for(int[] req : reqs) {
            int startTime = req[0];
            int meetTime = req[1];
            int type = req[2];
            Meet meet = new Meet(startTime, meetTime);

            if(map.containsKey(type)) {
                map.get(type).meets.add(meet);
            } else {
                map.put(type, new Info(type, meet));
            }
        }

        Queue<Info> infos = new PriorityQueue<>();
        for(int key : map.keySet()) {
            infos.add(map.get(key));
        }

        // 대기시간 계산
        for(Info info : infos) {
            info.calculateWaitTime();
            n--; // 유형별로 최소 1명씩 배치
        }

        while(n > 0) {
            //멘토한명씩 추가됐을 때 대기시간 계산
            for(Info info : infos) {
                info.calculateWaitTimeWithMentor();
            }

            //멘토 한명 추가했을 때, 대기시간이 가장 많이 줄어든 상담유형
            Info info = infos.poll();
            info.mentorCnt += 1;
            info.waitTime = info.waitTimeWhenAddMentor;
            infos.add(info);
            n--;
        }

        int result = 0;
        for(Info info : infos) {
            result += info.waitTime;
        }

        return result;
    }
}
