package LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */


import LinkedList.ListNode;

public class DetectACycleInLinkedList {


    //  Time Complexity: O(N)
    //  Reason: In the worst case, all the nodes of the list are visited.
    //  Space Complexity: O(1)

    public static boolean twoPointer(ListNode head){
        if(head == null) return false;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
