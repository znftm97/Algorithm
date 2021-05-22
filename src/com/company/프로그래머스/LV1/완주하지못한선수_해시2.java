package com.company.프로그래머스.LV1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*hash 이용해서 풀기*/
public class 완주하지못한선수_해시2 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        String answer = "";

        /*HashMap에 이름을 키로넣고 값을 넣을 때 getOrDefault 를 사용하는 이유는 동명이인인 경우 때문이다.
        * put의 두번째 파라미터에서 그냥 1 이라는 값을 넣게되면 이후 같은 이름을 가진 name이 온다면 둘다 1이될것이다.
        * 즉 A가 두명 들어오면 A=1, A=1 두 객체가 생성될 것이다.
        *
        * 근데 getOrDefault 메서드를 사용하면 A가 들어온후 또 A가 들어온다면 이전에 저장한 A를 다시불러와서
        * A=2가 될 것이다. 그래서 아래에서 1을 빼도 1이되기때문에 마지막 반복문에서 걸린다.
        * */
        for (String name : participant) {
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            hm.put(name, hm.get(name)-1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer=key;
                break;
            }
        }

        return answer;
    }
}
