   def reverseList(head: ListNode): ListNode = {
        
    if (head == null || head.next == null) {
      head
    } else {
      val reversed = reverseList(head.next)
      
      head.next.next = head
      head.next = null
      
      reversed

    }
        
    }
