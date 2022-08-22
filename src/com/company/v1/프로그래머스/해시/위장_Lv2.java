package com.company.v1.프로그래머스.해시;

import java.util.HashMap;

/*옷의 종류를 Key로, 종류의 수를 Value로 가지는 HashMap을 사용한다.
* 반복문으로 특정 종류의 옷이 있을때마다 값을 1씩 더한다.
* 경우의 수를 구하는 공식은 4종류의 옷과 그 옷이 {a, b, c, d}의 개수로 있을 때 아래와 같다.
* (a+1) * (b+1) * (c+1) * (d+1) - 1
* 각 종류들은 하나를 입거나, 안입거나의 선택지가 있기 때문에 옷의 개수에 안입는 선택지를 하나 추가한다.
* 옷을 고르는 선택은 동시에 일어나기 때문에 각 옷들을 곱해 경우의 수를 계산하며, 아무것도 입지 않는 선택지는 없으므로 1을 뺀다.
* */
public class 위장_Lv2 {
    public int solution(String[][] clothes) {
        int answer = 1; // 아래에서 곱연산을 하기때문에 0으로 하면 안된다.
        HashMap<String, Integer> map = new HashMap<>();

        /*clothes 배열의 두 번째 열에 의상의 종류가 있으므로 [i][1]로 고정한다. */
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            /*if(map.get(clothes[i][1]) == null) // 옷의 종류가 처음 나온경우
                map.put(clothes[i][1], 1);
            else // 이미 옷의 종류가 들어간 경우 키로 값을 꺼내서 +1
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);*/
        }

        /*키마다 즉 옷의 종류마다 개수를 꺼내서 위에서 말한 공식을 적용한다.*/
        for(String keys: map.keySet()) {
            answer *= (map.get(keys) + 1);
        }

        answer -= 1; // 아무것도 입지 않는 선택지는 뺀다.

        return answer;
    }
}
