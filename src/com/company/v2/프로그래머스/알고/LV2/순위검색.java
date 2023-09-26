package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 순위검색 {
    private static Map<String, List<Integer>> infoToScoreMap = new HashMap<>();

    public List<Integer> solution(String[] infos, String[] queries) {
        List<Integer> results = new ArrayList<>();

        for (String info : infos) {
            getComb(0, info.split(" "), "");
        }

        for (String info : infoToScoreMap.keySet()) {
            Collections.sort(infoToScoreMap.get(info));
        }

        for (String query : queries) {
            String separationStr = query.replaceAll(" and ", "");
            String[] arr = separationStr.split(" ");

            String condition = arr[0];
            int score = Integer.parseInt(arr[1]);
            results.add(binarySearch(condition, score));
        }

        return results;
    }

    private static void getComb(int depth, String[] infos, String info) {
        if (depth == 4) {
            if (!infoToScoreMap.containsKey(info)) {
                infoToScoreMap.put(info, new ArrayList<>());
            }

            infoToScoreMap.get(info).add(Integer.parseInt(infos[4]));
            return;
        }

        getComb(depth + 1, infos, info + "-");
        getComb(depth + 1, infos, info + infos[depth]);
    }

    private static int binarySearch(String info, int score) {
        if(!infoToScoreMap.containsKey(info)) return 0;

        List<Integer> scores = infoToScoreMap.get(info);
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }

        return scores.size() - start;
    }
}
