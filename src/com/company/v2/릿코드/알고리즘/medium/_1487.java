package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;

public class _1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nameToCntMap = new HashMap<>();
        String[] results = new String[names.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            String s = names[i];

            while (nameToCntMap.containsKey(s)) {
                sb.setLength(0);
                int cnt = nameToCntMap.get(names[i]) + 1;
                nameToCntMap.put(names[i], cnt);
                s = sb.append(names[i]).append("(").append(cnt).append(")").toString();
            }

            nameToCntMap.put(s, 0);
            results[i] = s;
        }

        return results;
    }
}
