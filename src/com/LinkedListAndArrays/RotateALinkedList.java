package com.LinkedListAndArrays;
/*
 *
 * @UtkarshAgarwal
 */

import com.LinkedList.ListNode;

public class RotateALinkedList {

    // Approach : Brute Force (for each iteration 1 to k move last node to first)
    // TC : O(N * K)
    // SC : O(1)
    public static ListNode bruteForce(ListNode head, int k){
        if(head == null || head.next == null)
            return head;
        for(int i = 1; i <= k ; i++){
            ListNode temp = head;
            while(temp.next.next != null)
                temp = temp.next;
            ListNode end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    // Approach :   Optimized (Converting k in range of length of Linked List
    //  TC : O(N)   make the list in circular remove the link of (n - k)th node)
    // SC : O(1)

    public static ListNode optimized(ListNode head, int k){
        int length = 0;
        ListNode temp = head;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }
        temp.next = head;
        temp = head;
        for(int i = 1 ; i < length - k ; i++)
            temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
