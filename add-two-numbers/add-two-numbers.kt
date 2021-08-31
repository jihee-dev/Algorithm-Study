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
        var nextNode1 = l1
        var nextNode2 = l2
        var carry = 0
        var tmpNode = ListNode(0)
        val resultNode = tmpNode

        while (nextNode1 != null || nextNode2 != null || carry > 0) {
            var tempSum = carry
            carry = 0

            if (nextNode1 != null) {
                tempSum += nextNode1.`val`
                nextNode1 = nextNode1.next
            }

            if (nextNode2 != null) {
                tempSum += nextNode2.`val`
                nextNode2 = nextNode2.next
            }

            if (tempSum >= 10) {
                tempSum %= 10
                carry = 1
            }

            tmpNode.next = ListNode(tempSum)
            tmpNode = tmpNode.next!!
        }

        return resultNode.next
    }
}