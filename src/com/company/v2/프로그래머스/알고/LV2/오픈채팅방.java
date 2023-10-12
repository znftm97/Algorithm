package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 오픈채팅방 {
    public List<String> solution(String[] records) {
        Map<String, String> uidToNameMap = new HashMap<>();
        List<String> histories = new ArrayList<>();

        for(String record : records) {
            String[] splits = record.split(" ");
            String command = splits[0];
            String uid = splits[1];

            if(command.equals("Enter")) {
                uidToNameMap.put(uid, splits[2]);
                histories.add(uid + "@님이 들어왔습니다.");
            } else if(command.equals("Leave")) {
                histories.add(uid + "@님이 나갔습니다.");
            } else {
                uidToNameMap.put(uid, splits[2]);
            }
        }

        List<String> results = new ArrayList<>();
        for(String history : histories) {
            String[] splits = history.split("@");
            String uid = splits[0];
            String str = splits[1];
            String name = uidToNameMap.get(uid);

            results.add(name + str);
        }

        return results;
    }
}
