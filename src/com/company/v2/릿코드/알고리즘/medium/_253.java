package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _253 {
    public int minMeetingRooms(int[][] intervals) {
        int roomCnt = 1;
        Queue<Integer> endTimes = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int beforeEnd = intervals[i][1];
            int afterStart = intervals[i + 1][0];

            if (beforeEnd > afterStart) {
                endTimes.add(beforeEnd);

                if (!endTimes.isEmpty() && afterStart >= endTimes.peek()) {
                    endTimes.poll();
                    continue; // 이전 회의실을 큐에서꺼내 사용했으므로 roomCnt 증감없이 다음으로
                }

                roomCnt++;
            }
        }

        return roomCnt;
    }
}
