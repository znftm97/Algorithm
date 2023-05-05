package com.company.v2.릿코드.알고리즘.easy

class _70 {
    fun climbStairs(n: Int): Int {
        val list = mutableListOf<Int>()
        list.add(1)
        list.add(2)

        for (i in 2 until n) {
            list.add(list[i - 2] + list[i - 1])
        }

        return list[n - 1]
    }
}