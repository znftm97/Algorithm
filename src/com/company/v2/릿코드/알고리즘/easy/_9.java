package com.company.v2.릿코드.알고리즘.easy;

public class _9 {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    /*O(1) 풀이라고는 하는데 3ms 차이밖에 안남*/
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int res = 0;
        while(x>res){
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return (x == res || x == res / 10);
    }
}
