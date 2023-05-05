package com.company.v2.릿코드.알고리즘.easy

class _217 {
    fun containsDuplicate(nums: IntArray) =
        nums.asList().any { num ->
            nums.count { it == num } >= 2
        }
}