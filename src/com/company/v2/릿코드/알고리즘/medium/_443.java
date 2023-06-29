package com.company.v2.릿코드.알고리즘.medium;

public class _443 {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;

        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                cnt++;
            } else {
                if(cnt == 1) sb.append(chars[i]);
                else sb.append(chars[i]).append(cnt);

                cnt = 1;
            }
        }

        if(cnt == 1) sb.append(chars[chars.length - 1]);
        else sb.append(chars[chars.length - 1]).append(cnt);

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
