package com.company.v1.프로그래머스.Etc;

import java.util.Stack;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int count = 1;
        Stack<Integer> st = new Stack<>();
        a -= 1;
        b -= 1; // 배열의 인덱스와 맞추기 위해

        while (true) {
            /*빈 스택에 peek 하면 오류나므로 처음은 그냥 값 넣어줌*/
            if (0 == a || 0 == b) {
                st.add(1);
            } else {
                st.add(0);
            }

            for (int i = 1; i < n; i++) {
                /*이전에 1값이 들어왔고 && 현재 1값이 들어가야하고 && i가 홀수라면 둘이 만난다.
                * i가 홀수일 때만 해야하는 이유는 0ab0 처럼 a와 b가 붙어있어도 서로 같은 대진이 아니기 때문에 앞에 숫자 즉 홀수일때만 검사해야한다.
                * */
                if (st.peek() == 1 && (i == a || i == b) && i%2!=0) {
                    return count;
                }

                if (i == a || i == b) {
                    st.add(1);
                } else {
                    st.add(0);
                }
            }

            /*안만났다면 스택을 비우고, 카운트 증가, 모든 숫자 나누기 2*/
            st.clear();
            count++;
            n = n/2;
            a = a/2;
            b = b/2;
        }
    }
}
