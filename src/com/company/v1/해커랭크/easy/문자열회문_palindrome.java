package com.company.v1.해커랭크.easy;

import java.io.IOException;

public class 문자열회문_palindrome {
    public static void main(String[] args) throws IOException {
        String s = "bavac";

        int start, end, a, b;
        /*회문 검색, 조건 만족안하면 바로 탈출*/
        for (start = 0, end = s.length() - 1; start < s.length(); start++, end--) {
            if (s.charAt(start) != s.charAt(end)){
                break;
            }
        }

        /*위 for문을 다 돌으면 start가 더 커짐 -> 즉 모두 회문조건을 만족했다는 얘기*/
        if (start > end) {
            System.out.println(-1);
            return;
        }

        /*처음에 a= start + 1 로 1을 더해주는 이유는 첫번째가 아닌 다음요소부터 회문검색을 모두 한 후
        * 만약 모두 같아서 if문에 안걸리면 맨 첫 요소를 제거하면됨
        * 만약 중간에 다른 부분이 발견되면 맨 끝요소를 제거하면 됨
        * */
        for (a = start + 1, b = end; a < end && b > start + 1; a++, b--) {
            if (s.charAt(a) != s.charAt(b)){
                System.out.println(end);
                return;
            }
        }

        System.out.println(start);
    }
}
