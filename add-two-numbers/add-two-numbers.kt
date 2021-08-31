/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNumbers(l1, l2, 0)
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }
        var temp = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        return ListNode(temp % 10).apply { next = addTwoNumbers(l1?.next, l2?.next, temp / 10) }
    }
}