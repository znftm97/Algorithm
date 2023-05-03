package com.company.v2.릿코드.알고리즘.easy

class _704 {
    fun search(nums: IntArray, target: Int): Int {
        var (start, end) = 0 to nums.size - 1

        while (start <= end) {
            val mid = start + end
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> start = mid + 1
                nums[mid] > target -> end = mid - 1
            }
        }

        return -1
    }
}