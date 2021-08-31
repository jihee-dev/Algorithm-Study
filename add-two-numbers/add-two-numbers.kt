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
        var carry = false
        var preNode = ListNode(0)
        var newNode: ListNode

        val resultNode = preNode

        while (true) {
            if (nextNode1 == null && nextNode2 == null) {
                if(carry) {
                    newNode = ListNode(1)
                    preNode.next = newNode
                    preNode = newNode
                }
                break
            }
            
            var tempSum = if (carry) 1 else 0
            carry = false

            if(nextNode1 != null) {
                tempSum += nextNode1.`val`
                nextNode1 = nextNode1.next
            }

            if(nextNode2 != null) {
                tempSum += nextNode2.`val`
                nextNode2 = nextNode2.next
            }

            if(tempSum >= 10) {
                tempSum %= 10
                carry = true
            }

            newNode = ListNode(tempSum)
            preNode.next = newNode
            preNode = newNode
        }

        return resultNode.next
    }
}