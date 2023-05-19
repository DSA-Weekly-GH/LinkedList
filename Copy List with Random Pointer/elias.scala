/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var next: Node = null
 *   var random: Node = null
 * }
 */

object Solution {
    def copyRandomList(head: Node): Node = {

        if (head == null) return null

        val nodeMap = scala.collection.mutable.Map[Node, Node]()
        
        var current: Node = head
        var newHead: Node = null
        var newCurrent: Node = null
    

        while (current != null){

            val newNode = new Node(current.value)

            nodeMap.put(current, newNode)

            if (newHead == null) {
                newHead = newNode
                newCurrent = newNode

            } else {
                newCurrent.next = newNode
                newCurrent = newCurrent.next
            }

                current = current.next
        }

            
        // Update the next pointers of the new linked list using the node mapping
        current = head
        newCurrent = newHead

        while (current != null) {
            

            if (current.random == null){

                newCurrent.random = null

            } else {
                // newCurrent.next = nodeMap(current.next)

                newCurrent.random = nodeMap(current.random)
            }

            current = current.next
            newCurrent = newCurrent.next
        }

        newHead
        
    }
}
