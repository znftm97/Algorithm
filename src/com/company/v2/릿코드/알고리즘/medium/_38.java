package com.company.v2.릿코드.알고리즘.medium;

public class _38 {
    private StringBuilder sb = new StringBuilder();
    private StringBuilder result = new StringBuilder();

    public String countAndSay(int n) {
        switch (n) {
            case 1 -> {return "1";}
            case 2 -> {return "11";}
        }

        sb.append(11);
        for (int i = 3; i <= n; i++) {
            result.setLength(0);
            generate(i);
        }

        return result.toString();
    }

    private void generate(int num) {
        String s = sb.toString();
        int cnt = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                result.append(cnt).append(s.charAt(i));
                cnt = 1;
            }
        }

        result.append(cnt).append(s.charAt(s.length() - 1));
        sb.setLength(0);
        sb.append(result);
    }
}
