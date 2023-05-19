object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var slow = head
    var fast = head

    // Move the fast pointer n positions ahead
    for (i <- 1 to n) {
        fast = fast.next
    }

    // If the fast pointer is null, it means we need to remove the head of the linked list
    if (fast == null) {
        return head.next
    }

    // Move both the slow and fast pointers until the fast pointer reaches the end of the linked list
    while (fast.next != null) {
        slow = slow.next
        fast = fast.next
    }

        // Remove the nth node from the end of the linked list
        slow.next = slow.next.next

        return head
    }



}
