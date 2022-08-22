package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 킹_1063 {
    private static final int KING = 1;
    private static final int STONE = -1;
    static int[][] map = new int[8][8];
    static Character[] row1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static Character[] col1 = {'8', '7', '6', '5', '4', '3', '2', '1'};
    static List<Character> row = Arrays.asList(row1);
    static List<Character> col = Arrays.asList(col1);

    enum Move{
        R(0, 1), L(0, -1), B(1, 0), T(-1, 0), RT(-1,1), LT(-1, -1), RB(1, 1), LB(1, -1);
        public int r;
        public int c;

        Move(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static boolean isAbleArea(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < 8 && nc < 8) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPos = st.nextToken();
        String stonePos = st.nextToken();

        int kr = row.indexOf(kingPos.charAt(0));
        int kc = col.indexOf(kingPos.charAt(1));
        int sr = row.indexOf(stonePos.charAt(0));;
        int sc = col.indexOf(stonePos.charAt(1));
        int testCase = Integer.parseInt(st.nextToken());

        map[kr][kc] = KING;
        map[sr][sc] = STONE;

        for (int t = 0; t < testCase; t++) {
            Move m = Move.valueOf(br.readLine());
            int newKr = kr + m.r;
            int newKc = kc + m.c;
            int newSr = sr;
            int newSc = sc;

            if(newKr == sr && newKc == sc) {
                newSr = sr + m.r;
                newSc = sc + m.c;
            }

            if(isAbleArea(newKr, newKc) && isAbleArea(newSr, newSc)){
                kr = newKr;
                kc = newKc;
                sr = newSr;
                sc = newSc;
            }
        }

        System.out.println(row1[kr] + "" + col1[kc]);
        System.out.println(row1[sr] + "" + col1[sc]);
        br.close();
    }
}
