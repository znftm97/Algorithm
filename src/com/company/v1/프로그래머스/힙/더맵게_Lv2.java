package com.company.v1.프로그래머스.힙;

import java.util.PriorityQueue;

/* 1. 우선순위 큐에 담아 오름차순으로 정렬
   2. 맨 앞에 2개 꺼내서 연산 수행 후 나온 값 다시 넣기
      우선순위 큐니까 걍 넣으면 알아서 정렬됨
   3. 각 음식들이 모두 K 이상인지 검사
      모두 검사할필요없음 어차피 맨앞이 최소값
      그러면 맨앞이 만약 k보다 크다? 그러면 조건만족한거임
   4. k 이상으로 만들 수 없는경우
     모든 음식을 다 더해서 딱 1개의 음식이 남았는데 k보다 작을경우 return -1
* */
public class 더맵게_Lv2 {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            /*맨 앞의 두 숫자를 꺼내서 새로운 숫자를 넣는 방식이라 큐 길이의 -1 만큼 반복해야함*/
            for (int i = 0; i < pq.size() - 1; i++) {
                pq.add(pq.poll() + (pq.poll() * 2)); // 연산 수행 후 큐에 추가
                count++; // 연산 수행 후 큐에 추가하면 카운팅

                /*조건 만족하는지 검사*/
                for (int j = 0; j < pq.size(); j++) {
                    /*큐에서 꺼낸 숫자가 K보다 작은데 큐에 값이 하나 뿐이라면 조건 만족하지 못함*/
                    if (K > pq.peek() && pq.size() == 1) {
                        return -1;
                    }

                    /*큐에서 꺼낸값이 K보다 작으면 다시 연산 수행하러*/
                    if (K > pq.peek()) {
                        break;
                    } else if (K <= pq.peek()) { // 큐에서 꺼낸 값이 K보다 크거나 같으면 조건 만족 카운팅 수 리턴 , 우선순위 큐이기 때문에 큐에서 꺼낸 값은 항상 최소값임
                        return count;
                    }
                }
            }
        }

        return 0;
    }
}
