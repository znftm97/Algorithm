package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _6 {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int r = 0;
        boolean isDown = false;

        for (char c : s.toCharArray()) {
            rows.get(r).append(c);

            if (r == 0 || r == numRows - 1) isDown = !isDown;
            r += isDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
