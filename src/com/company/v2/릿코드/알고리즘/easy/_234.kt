package com.company.v2.릿코드.알고리즘.easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun isPalindrome(head: ListNode?): Boolean {
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