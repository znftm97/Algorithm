package com.company.v1.코드트리.알고리즘기본.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실준비구현 {

    private static class Meeting implements Comparable<Meeting>{
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.endTime - m.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings);

        int result = 0;
        int beforeMeetingEndTime = 0;
        for (int i = 0; i < meetings.size(); i++) {
            Meeting afterMeeting = meetings.get(i);

            if (afterMeeting.startTime >= beforeMeetingEndTime) {
                result++;
                beforeMeetingEndTime = afterMeeting.endTime;
            }
        }

        System.out.println(result);
    }
}
