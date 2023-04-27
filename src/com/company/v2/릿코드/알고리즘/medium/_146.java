package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _146 {
    /* 통과 */
    private static class LRUCache2 {

        private Map<Integer,Integer> cache;

        public LRUCache2(int capacity) {
            this.cache = new CLinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }

        private static class CLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

            int capacity;

            public CLinkedHashMap(int capacity) {
                super(capacity, 0.75f, true);
                this.capacity = capacity;
            }

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        }
    }

    /* 시간초과 */
    private static class LRUCache {

        private int capacity = 0;
        private Map<Integer, Integer> cache = new LinkedHashMap<>();
        private Deque<Integer> lru = new ArrayDeque<>(3001);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            lru = new ArrayDeque<>(capacity);
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;

            moveToFirst(key);

            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                moveToFirst(key);
                return;
            }

            if (cache.size() >= capacity) {
                cache.remove(lru.pollLast());
            }

            lru.addFirst(key);
            cache.put(key, value);
        }

        private void moveToFirst(int key) {
            lru.remove(key);
            lru.addFirst(key);
        }
    }
}
