package com.company.v2.릿코드.알고리즘.medium;

public class _1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] alphabetCounts = new int[26];
        int cnt = 0;
        int maxCnt = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            alphabetCounts[ch - 'a']++;

            if (ch == 'c') {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            } else {
                if(!valid(ch, alphabetCounts)) return -1;
                if (ch == 'k') cnt--;
            }
        }

        return cnt == 0 ? maxCnt : -1;
    }

    private boolean valid(char ch, int[] alphabetCounts) {
        char prevCh;

        if(ch == 'r') prevCh = 'c';
        else if(ch == 'o') prevCh = 'r';
        else if(ch == 'a') prevCh = 'o';
        else prevCh = 'a';

        return alphabetCounts[prevCh - 'a'] >= alphabetCounts[ch - 'a'];
    }
}
