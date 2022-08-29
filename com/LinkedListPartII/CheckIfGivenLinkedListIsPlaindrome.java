package LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */


import LinkedList.ListNode;

public class CheckIfGivenLinkedListIsPlaindrome {
    public static void main(String[] args) {

    }

    public static boolean optimized(ListNode head){
        ListNode middle = middleNode(head);
        middle.next = reverse(middle.next);
        middle = middle.next;
        ListNode start = head;
        while(middle != null){
            if(middle.val == start.val){
                middle = middle.next;
                start = start.next;
            }else{
                return false;
            }
        }
        return true;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, nex = node;
        while(curr != null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
