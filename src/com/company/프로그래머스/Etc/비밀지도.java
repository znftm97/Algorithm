package com.company.프로그래머스.Etc;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] map = new boolean[n][n];
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String s1 = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }

            String s2 = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
            for (int j = 0; j < s2.length(); j++) { // 문자열 하나씩 나눠서
                if (s2.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == true) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
}
