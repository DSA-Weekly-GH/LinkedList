/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *     var next: ListNode = _next
 *     var x: Int = _x
 * }
 */
object Solution {
    def reorderList(head: ListNode): Unit = {
        if (head == null || head.next == null) return
        
        // Find the middle node
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next.next
        }
        
        // Split the linked list into two halves
        var head1 = head
        var head2 = slow.next
        slow.next = null
        
        // Reverse the second half of the linked list
        var prev: ListNode = null
        var curr = head2
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        head2 = prev
        
        // Merge the two linked lists
        var p1 = head1
        var p2 = head2
        while (p2 != null) {
            val next1 = p1.next
            val next2 = p2.next

            p1.next = p2
            p2.next = next1
            
            p1 = next1
            p2 = next2
        }
    }
}
