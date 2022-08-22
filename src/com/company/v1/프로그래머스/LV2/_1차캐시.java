package com.company.v1.프로그래머스.LV2;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class _1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new LinkedList<>();
        int runTime = 0;

        if (cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);

            if (cache.contains(city)) { // 캐시 히트한 도시는 맨뒤로 이동 (제거 후 새로 추가)
                runTime++;
                cache.remove(city);
                cache.add(city);
            } else {
                runTime += 5;

                if (cache.size() == cacheSize) {
                    cache.remove(0); // 제일 오래된 원소 삭제
                    cache.add(city);
                } else {
                    cache.add(city);
                }
            }
        }

        return runTime;
    }

}
