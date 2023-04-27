package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0) {
                map.put(nums[i-1], map.get(nums[i-1]) - 1);
            }
            for (int j = i; j < nums.length - 1; j++) {
                countMap.clear();

                int sum = nums[i] + nums[j];
                int negativeSum = sum * -1;
                if (map.containsKey(negativeSum)) {
                    List<Integer> integers = new ArrayList<>(List.of(nums[i], nums[j], negativeSum));
                    Collections.sort(integers);
                    if (result.contains(integers)) {
                        continue;
                    }
                    integers.forEach(number -> countMap.put(number, countMap.getOrDefault(number, 0) + 1));

                    boolean addTarget = countMap.entrySet().stream().allMatch(entry -> map.get(entry.getKey()) >= entry.getValue());
                    if (addTarget) {
                        result.add(integers);
                    }
                }
            }
        }

        return result.stream().toList();
    }
}
