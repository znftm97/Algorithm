package com.company.프로그래머스.LV1;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k){
        int[] result = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> duplicateCheck = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
        }

        for (String s : report) {
            st = new StringTokenizer(s);
            String from = st.nextToken(); // 신고한사람
            String to = st.nextToken(); // 신고당한사람

            if (!duplicateCheck.containsKey(to)) duplicateCheck.put(to, new ArrayList<>()); // 첫 신고 당한사람이면 신고한사람 목록 생성
            List<Integer> reporters = duplicateCheck.get(to); // 신고한 사람 목록

            Integer idIdx = index.get(from); // 신고한사람 인덱스
            if(!reporters.contains(idIdx)) reporters.add(index.get(from)); // 처음 신고한 사람이라면 추가
        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if(duplicateCheck.containsKey(id) && duplicateCheck.get(id).size() >= k){ // k번 이상 신고당한사람
                List<Integer> reporters = duplicateCheck.get(id); // k번 이상 신고당한 사람을 신고한 사람들 목록
                for (int idx : reporters) {
                    result[idx]++;
                }
            }
        }

        return result;
    }

}
