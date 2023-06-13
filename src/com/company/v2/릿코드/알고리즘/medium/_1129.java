package com.company.v2.릿코드.알고리즘.medium;

public class _1129 {
    private int[] results;
    private boolean[] visit;
    private int N;

    public int[] constructDistancedSequence(int n) {
        results = new int[2 * n - 1];
        visit = new boolean[n+1];
        N = n;
        recursion(0);
        return results;
    }

    private boolean recursion(int depth) {
        if(depth == results.length) return true;
        if(results[depth] != 0) return recursion(depth + 1);

        for (int i = N; i > 0; i--) {
            if (!visit[i] && (i == 1 || depth + i < results.length && results[i + depth] == 0)) {
                visit[i] = true;
                results[depth] = i;
                if(i != 1) results[depth + i] = i;

                if(recursion(depth + 1)) return true;

                visit[i] = false;
                results[depth] = 0;
                if(i != 1) results[depth + i] = 0;
            }
        }

        return false;
    }
}
