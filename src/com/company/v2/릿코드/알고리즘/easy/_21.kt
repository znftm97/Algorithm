package com.company.v2.릿코드.알고리즘.easy

class ListNode(var value: Int) {
    var next: ListNode? = null
}

class _21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null && list2 == null) return ListNode(0)
        else if(list1 == null && list2 != null) return list2
        else if(list1 != null && list2 == null) return list1

        val nums1 = list1.toList()!!
        val nums2 = list2.toList()!!

        nums1.addAll(nums2)
        return nums1.sorted().toListNode()
    }

    private fun ListNode?.toList(): MutableList<Int>? {
        var listNode: ListNode? = this ?: return null

        val result = mutableListOf<Int>()
        while (true) {
            result.add(listNode!!.value)
            if(listNode.next == null) break
            listNode = listNode.next
        }

        return result
    }

    private fun List<Int>.toListNode(): ListNode {
        val list = this
        var node = ListNode(list.first())
        var nowNode = node

        for (i in 1 until list.size) {
            val nextNode = ListNode(list[i])
            nowNode.next = nextNode
            nowNode = nextNode
        }

        return node
    }
}