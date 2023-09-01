package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class _호텔대실 {
    static class Time{
        int start,end,room;

        public Time(String start, String end) {
            String[] split = start.split(":");
            this.start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            split = end.split(":");
            this.end = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
    }

    public int solution(String[][] book_time) {
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            times.add(new Time(book_time[i][0], book_time[i][1]));
        }
        times.sort((o1, o2) -> {
            if (o1.start == o2.start) return Integer.compare(o1.end, o2.end);
            return Integer.compare(o1.start, o2.start);
        });

        int room = 0;
        Map<Integer, Time> roomToTimeMap = new HashMap<>();
        Queue<Time> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for (Time now : times) {
            if (pq.isEmpty()) {
                now.room = room;
                pq.add(now);
                roomToTimeMap.put(room++, now);
                continue;
            }

            Time before = pq.peek();
            if (now.start >= before.end + 10) {
                roomToTimeMap.put(before.room, now);
                pq.poll();
            } else {
                roomToTimeMap.put(room++, now);
            }

            pq.add(now);
        }

        return roomToTimeMap.size();
    }

}
