package com.company.v2.릿코드.알고리즘.medium

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {
    var result: Int = nums[0]
    val dp = IntArray(nums.size)
    dp[0] = nums[0]

    val sorted = listOf(1, 2).sorted()

    for (i: Int in 1 until nums.size) {
        dp[i] = max(dp[i-1] + nums[i], nums[i])
        result = max(result, dp[i])
    }

    return result
}

fun main(){
    println(maxSubArray(IntArray(1) { 1 }))
}