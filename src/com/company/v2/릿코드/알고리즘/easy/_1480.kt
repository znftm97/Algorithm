package com.company.v2.릿코드.알고리즘.easy

class _1480 {
    fun runningSum(nums: IntArray): IntArray {
        val results = mutableListOf<Int>()
        results.add(nums[0])

        for (i in 1 until nums.size) {
            results.add(results[i-1] + nums[i])
        }

        return results.toIntArray()
    }
}