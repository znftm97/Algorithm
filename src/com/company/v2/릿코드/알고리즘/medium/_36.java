package com.company.v2.릿코드.알고리즘.medium;

public class _36 {
    private int[][] map = new int[9][9];

    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(board[r][c] == '.') map[r][c] = 0;
                else map[r][c] = board[r][c] - '0';
            }
        }

        return validGrid() && validRow() && validCol();
    }

    private boolean validGrid() {
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                boolean[] numChecks = new boolean[10];

                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if(map[r][c] == 0) continue;
                        else if(numChecks[map[r][c]]) return false;
                        else numChecks[map[r][c]] = true;
                    }
                }
            }
        }

        return true;
    }

    private boolean validRow() {
        for (int r = 0; r < 9; r++) {
            boolean[] numChecks = new boolean[10];
            for (int c = 0; c < 9; c++) {
                if(map[r][c] == 0) continue;
                else if(numChecks[map[r][c]]) return false;
                else numChecks[map[r][c]] = true;
            }
        }

        return true;
    }

    private boolean validCol() {
        for (int c = 0; c < 9; c++) {
            boolean[] numChecks = new boolean[10];
            for (int r = 0; r < 9; r++) {
                if(map[r][c] == 0) continue;
                else if(numChecks[map[r][c]]) return false;
                else numChecks[map[r][c]] = true;
            }
        }

        return true;
    }
}
