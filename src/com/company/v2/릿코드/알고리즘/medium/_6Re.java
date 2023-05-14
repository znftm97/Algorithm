package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _6Re {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<List<Character>> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strs.add(new ArrayList<>());
        }

        int[] dr = {1,-1};
        int r = 0;
        int idx = 0;
        int dir = 0;

        while (idx < s.length()) {
            strs.get(r).add(s.charAt(idx));

            if (r == numRows - 1 || (r == 0 && idx != 0)) {
                dir++;
                dir %= 2;
            }

            r += dr[dir];
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> list : strs){
            for (Character c : list) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
