package com.company.v2.릿코드.알고리즘.medium;

public class _394 {
    private static int idx = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String pieceStr = "";

        while (idx < s.length()) {
            char c = s.charAt(idx++);

            if (c == '[') {
                pieceStr = decodeString(s);
                for (int i = 0; i < count; i++) {
                    sb.append(pieceStr);
                }
                count = 0;
            } else if (c == ']') {
                break;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }
}
