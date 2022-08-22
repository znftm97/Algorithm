package com.company.v1.백준.큐.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        int firstQSize = Integer.parseInt(st.nextToken());
        int pickCount = Integer.parseInt(st.nextToken());
        int qMiddleSize = 0;
        int count = 0;

        for (int i = 1; i <= firstQSize; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pickCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            int numIndex = deque.indexOf(num) + 1;
            int startIndex = 1;
            int endIndex = deque.size();
            int dequeSize = deque.size();

            if(dequeSize % 2 == 0) qMiddleSize = dequeSize/2;
            else qMiddleSize = dequeSize/2 + 1;

            while (true) {
                if (numIndex > qMiddleSize) {
                    if (endIndex == numIndex) { // 원래는 맨앞에서만 값을 뽑을 수 있다. 그래서 뽑을값이 맨뒤에 왔을 때 앞으로 보내지말고 그냥 맨뒤에서 뽑고 카운트++ 해주면된다.
                        deque.pollLast();
                        count++;
                        break;
                    }
                    deque.addFirst(deque.pollLast()); // 맨뒤에 값을 맨앞으로
                    endIndex--;
                    count++;
                } else if (numIndex <= qMiddleSize) {
                    if (startIndex == numIndex) {
                        deque.pollFirst();
                        break;
                    }
                    deque.addLast(deque.pollFirst()); // 맨앞에 값을 맨뒤로
                    startIndex++;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
