package com.company.v1.프로그래머스.스택큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 1. 주어진 배열을 이용해 각 작업이 완료되는 날짜를 Stack으로 만들어 저장한다.
*  2. 스택에서 pop으로 값을 하나 꺼내고, 이후 peek로 꺼낸 값이 더 작다면 작업이 완료된거니 카운팅
*  3. 카운팅한 값들은 List에 저장하고 배열로 변환 후 리턴
* */
public class 기능개발_Lv2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        /*1번 과정
        * 스택은 후입선출 구조이므로, 배열의 끝에서부터 시작해야함 그래야 스택 맨위에 배열의 첫번째 요소의 날짜가 위치함
        * */
        for (int i = progresses.length - 1; i >= 0; i--) {
            int n = progresses[i];

            /*작업이 100 이상이 될때까지 반복하고 100이상이 되면, 스택에 넣고 반복문 탈출
            * 그러면 작업한 날짜가 스택에 저장
            * */
            while (true) {
                n += speeds[i];
                count++;
                if (n >= 100) {
                    stack.add(count);
                    break;
                }
            }
            count = 0;
        }

        List<Integer> s = new ArrayList<>();
        while (!stack.isEmpty()) {
            int cnt = 1; // 첫 스택에서 꺼내는 요소는 무조건 100 이상이니까 1로 설정해줘야함
            int top = stack.pop();

            /*다음 요소가 더 작다면 즉 이미 진도가 100이상이라는 얘기임, 스택에서 꺼내고 카운팅*/
            while (!stack.isEmpty() && stack.peek() <= top) {
                cnt++;
                stack.pop();
            }

            s.add(cnt);
        }

        int[] answer = new int[s.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.get(i);
        }

        return answer;
    }
}
