package com.company.프로그래머스.LV2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeOfClothes = new HashMap<>();
        int result = 1;

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            typeOfClothes.put(type, typeOfClothes.getOrDefault(type, 0) + 1);
        }

        for (String key : typeOfClothes.keySet()) {
            result *= (typeOfClothes.get(key) + 1); // 옷을 안입는 경우도 있으니 +1 (투명옷을 하나 추가했다고 생각)
        }

        return result - 1; // 모든 의상 종류를 투명옷으로 선택한 경우, 즉 아무것도 안입는 경우 제외
    }

}
