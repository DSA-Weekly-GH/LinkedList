/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
   
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
       
        def addLists(l1: ListNode, l2: ListNode, carry: Int): ListNode = {
            (l1, l2) match {
                case (null, null) => if (carry > 0) new ListNode(carry) else null
                case (null, _) => addLists(new ListNode(0), l2, carry)
                case (_, null) => addLists(l1, new ListNode(0), carry)
                case (l1, l2) =>
                val sum = l1.x + l2.x + carry
                val value = sum % 10
                val newCarry = sum / 10
                new ListNode(value, addLists(l1.next, l2.next, newCarry))
            }
        }

        addLists(l1, l2, 0)
    }
}
