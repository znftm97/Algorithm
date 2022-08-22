package com.company.v1.프로그래머스.Etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class 오픈채팅방 {
    public String[] solution(String[] record) {
        ArrayList<String> chatLog = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<>();

        for(String log : record){
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";

            if(!command.equals("Leave")){
                nickname = st.nextToken();
            }

            switch(command){
                case "Enter":
                    nickMap.put(userId, nickname);
                    chatLog.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    chatLog.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    nickMap.put(userId, nickname);
                    break;
            }
        }

        String[] answer = new String[chatLog.size()];
        int logIdx = 0;

        for(String str : chatLog){
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);

            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
        }

        return answer;
    }
}

