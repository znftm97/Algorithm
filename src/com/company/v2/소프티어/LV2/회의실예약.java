package com.company.v2.소프티어.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실예약 {
    private static class Meet implements Comparable<Meet> {
        String roomName;
        int start;
        int end;

        public Meet(String roomName, int start, int end) {
            this.roomName = roomName;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet m){
            return Integer.compare(this.start, m.start);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int roomCnt = Integer.parseInt(st.nextToken());
        int metting = Integer.parseInt(st.nextToken());
        Map<String, List<Meet>> roomToMeetsMap = new HashMap<>();
        Map<String, List<String>> roomToRestTimeMap = new HashMap<>();
        List<String> rooms = new ArrayList<>();

        for(int i = 0; i<roomCnt; i++){
            String room = br.readLine();
            rooms.add(room);
            roomToMeetsMap.put(room, new ArrayList<>());
        }

        for(int i = 0; i< metting; i++) {
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            roomToMeetsMap.get(roomName).add(new Meet(roomName, start, end));
        }

        for (String room : rooms) {
            roomToRestTimeMap.put(room, new ArrayList<>());

            List<Meet> meets = roomToMeetsMap.get(room);
            if (meets.isEmpty()) {
                roomToRestTimeMap.get(room).add(generateTime(9, 18));
            }

            Collections.sort(meets);
            List<String> restTimes = new ArrayList<>();
            int time = 9;

            for(Meet meet : meets) {
                restTimes = roomToRestTimeMap.get(meet.roomName);
                if(time < meet.start) {
                    restTimes.add(generateTime(time, meet.start));
                }

                time = meet.end;
            }

            if(time != 18) restTimes.add(generateTime(time, 18));
        }

        System.out.println(print(roomToRestTimeMap));
    }

    private static String generateTime(int start, int end) {
        String front = String.valueOf(start);
        String back = String.valueOf(end);
        if(front.equals("9")) front = "09";

        return front + "-" + back;
    }

    private static String print(Map<String, List<String>> roomToRestTimeMap) {
        List<String> keys = new ArrayList<>(roomToRestTimeMap.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();

        for(String key : keys) {
            List<String> restTimes =  roomToRestTimeMap.get(key);
            sb.append("Room ").append(key).append(":").append("\n");

            if(restTimes.isEmpty()) {
                sb.append("Not available").append("\n").append("-----").append("\n");
                continue;
            }

            sb.append(restTimes.size()).append(" ").append("available").append(":").append("\n");
            for(String restTime : restTimes) {
                sb.append(restTime).append("\n");
            }
            sb.append("-----").append("\n");
        }

        sb.delete(sb.length() - 6, sb.length());
        return sb.toString();
    }
}
