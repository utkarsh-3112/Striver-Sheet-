package LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */

import LinkedList.ListNode;
public class ReverseALinkedListInGroupsOfSizeK {
    public static void main(String[] args) {

    }


//    Time Complexity: O(N)
//    Reason: Nested iteration with O((N/k)*k) which makes it equal to O(N).
//    Space Complexity: O(1)


    public static ListNode solve(ListNode head, int k){
        if(head == null || head.next == null)
            return head;

        int length = length(head);
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr, nex;
        while(length >= k){
            curr = prev.next;
            nex = curr.next;
            for(int i = 1 ; i < k ; i++){
                curr.next = nex.next;           // just think after reversing links between two nodes linked will look like
                nex.next = prev.next;           // second  to first and first next to second next when we reverse
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummyNode.next;

    }
    public static int length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

}
