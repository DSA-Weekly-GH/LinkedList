
 def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
        val head = new ListNode()
        var tail = head

        var second = list2
        var first = list1

        while(first != null && second != null){
            
            if (first.x <= second.x){
                tail.next = first
                first = first.next
            } else {
                tail.next = second
                second = second.next
            }

            tail = tail.next

        }

        if (first != null){
            tail.next = first
        } else if (second != null){
            tail.next = second
        }

        return head.next

        
    }
