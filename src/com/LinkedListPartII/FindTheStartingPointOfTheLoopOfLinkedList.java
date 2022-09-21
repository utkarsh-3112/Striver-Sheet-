package com.LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */

import com.LinkedList.ListNode;

import java.util.HashSet;

public class FindTheStartingPointOfTheLoopOfLinkedList {
    public static void main(String[] args) {

    }

    // Approach : Brute Force
    // TC :
    // SC :

    public static ListNode bruteForce(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // Approach : Optimized Two pointer
    // Time Complexity: O(N)
    // Reason: We can take overall iterations and club them to O(N)
    // Space Complexity: O(1)

    public static ListNode optimized(ListNode head){
        if(head == null)
            return null;
        ListNode p = head, q = head;
        while(q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
            if(p == q){
                break;
            }
        }
        if(q.next == null || q.next.next == null)
            return null;
        p = head;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

}
