package com.company.v2.릿코드.알고리즘.easy

class ListNode2(var `val`: Int) {
    var next: ListNode2? = null
}

fun isPalindrome(head: ListNode2?): Boolean {
    head ?: return false
    var headNode = head!!
    val nums = mutableListOf<Int>()

    while (true) {
        nums.add(headNode.`val`)
        val nextNode = headNode.next ?: break
        headNode = nextNode
    }

    return nums == nums.reversed()
}