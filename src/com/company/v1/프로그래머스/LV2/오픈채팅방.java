package com.company.v1.프로그래머스.LV2;

import java.util.*;

public class 오픈채팅방 {
    public List<String> solution(String[] records) {
        List<String> result = new ArrayList<>();
        List<String> chatLogs = new ArrayList<>();
        Map<String, String> uidAndName = new HashMap<>();

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String command = st.nextToken();
            String uid = st.nextToken();
            String name = "";

            if (!command.equals("Leave")) name = st.nextToken();

            if (command.equals("Enter")) {
                chatLogs.add(uid + "@님이 들어왔습니다.");
                uidAndName.put(uid, name);
            } else if (command.equals("Leave")) {
                chatLogs.add(uid + "@님이 나갔습니다.");
            } else {
                uidAndName.put(uid, name);
            }
        }

        for (String s : chatLogs) {
            StringTokenizer st = new StringTokenizer(s, "@");
            String uid = st.nextToken();
            String name = uidAndName.get(uid);

            result.add(s.replace(uid+"@", name));
        }

        return result;
    }

}
