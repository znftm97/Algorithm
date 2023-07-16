package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class _71 {
    public String simplifyPath(String path) {
        List<String> diretories = generateDirectories(path);
        Stack<String> q = applyCondition(diretories);

        return makeSimplifyPath(q);
    }

    private List<String> generateDirectories(String path) {
        if(path.charAt(0) != '/') path = '/' + path;

        List<String> diretories = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(path, "/");
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if(!s.equals(".")) diretories.add(s);
        }

        return diretories;
    }

    private Stack<String> applyCondition(List<String> directories) {
        Stack<String> stack = new Stack<>();

        for (String s : directories) {
            if(!s.equals("..")) stack.add(s);
            else if(!stack.isEmpty()) stack.pop();
        }

        return stack;
    }

    private String makeSimplifyPath(Stack<String> q) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");

        for (String s : q) {
            sb.append(s).append("/");
        }

        return sb.length() == 1 ? sb.toString() : sb.deleteCharAt(sb.length() - 1).toString();
    }
}
