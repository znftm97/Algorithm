package com.company.프로그래머스.스택큐;

import java.util.Stack;

public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 스택에서 맨 위값과 비교해야 하는데 비어있으면 에러나기 때문에 0 삽입

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) { // 하나의 열이 모두 0인경우는 수행할 필요 없음
                    if (stack.peek() == board[j][move - 1]) { // 스택에 있는 값과 넣을 값이 같다면
                        stack.pop(); // 스택에 있는 값 제거해줌
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]); // 스택에 있는 값과 다르면 그대로 스택에 push
                    }
                    board[j][move - 1] = 0; // 배열에서 뽑은 값 0으로 세팅
                    break; // 다음 move, 즉 다음 인형뽑으로
                }
            }
        }
        return answer;
    }
}
