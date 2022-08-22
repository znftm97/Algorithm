package com.company.v1.동빈북.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*첫번째로 시작하는 수가 아닌 숫자를, 첫번째로 시작하는 수로 뒤집으면 된다.
 * 즉 첫번째로 시작하는 수로 뒤집는 횟수를 카운팅
 * */
public class 문자열뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        boolean flag = true;
        String s = br.readLine();
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (c != s.charAt(i) && flag) {
                result++;
                flag = false;
            } else if(c == s.charAt(i)){
                flag = true;
            }
        }

        System.out.println(result);
    }
}
