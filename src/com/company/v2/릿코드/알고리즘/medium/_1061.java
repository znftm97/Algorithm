package com.company.v2.릿코드.알고리즘.medium;

public class _1061 {
    int[] parent;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            int pa = find(a);
            int pb = find(b);

            if (pa < pb) parent[pb] = pa;
            else parent[pa] = pb;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            char cc = (char) (find(c - 'a') + 'a');
            sb.append(cc);
        }

        return sb.toString();
    }

    int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
