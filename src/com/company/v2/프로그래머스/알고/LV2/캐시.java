package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        for(int i = 0; i<cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int time = 0;
        Queue<String> cache = new LinkedList<>();
        for(int i = 0; i<cities.length; i++) {
            String city = cities[i];

            if(cache.contains(city)) {
                time+=1;
                cache.remove(city);
                cache.add(city);
                continue;
            }

            time+=5;
            if(cache.size() < cacheSize) {
                cache.add(city);
            } else {
                cache.poll();
                cache.add(city);
            }
        }

        return time;
    }
}
