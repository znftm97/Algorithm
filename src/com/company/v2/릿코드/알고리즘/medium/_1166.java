package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;

public class _1166 {
    public static class FileSystem {

        private Map<String, Integer> map;

        public FileSystem() {
            this.map = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            if(map.containsKey(path) || path.isEmpty() || path.charAt(0) != '/') return false;

            int lastSlashIdx = path.lastIndexOf("/");
            if(lastSlashIdx == 0) {
                map.put(path, value);
                return true;
            }

            String parent = path.substring(0, lastSlashIdx);
            if(!map.containsKey(parent)) return false;

            map.put(path, value);

            return true;
        }

        public int get(String path) {
            return map.getOrDefault(path, -1);
        }
    }
}
