package com.company.v1.해커랭크.easy;

import java.io.IOException;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        String str = "abcaaabbbcc";
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < length; i++) {
            /*마지막 문자까지 왔을 때*/
            if (i == length - 1) {
                if (count != 1) { // 중복 있으면 count와 같이 출력
                    sb.append(str.charAt(i)).append(count);
                    break;
                } else { // 중복 없으면 그냥 문자만 출력
                    sb.append(str.charAt(i));
                    break;
                }
            }

            if (str.charAt(i) == str.charAt(i + 1)) { // 앞뒤 같으면 카운팅
                count++;
            } else { // 앞뒤 다른경우
                if (count != 1) { // 앞뒤 다를때 카운팅 쌓여있으면 문자 + 카운팅 같이 출력
                    sb.append(str.charAt(i)).append(count);
                    count = 1;
                } else { // 앞뒤 다를때 카운팅 안쌓였으면 문자만 출력
                    sb.append(str.charAt(i));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
