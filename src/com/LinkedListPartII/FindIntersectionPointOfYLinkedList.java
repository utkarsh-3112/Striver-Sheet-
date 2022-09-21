package com.LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */

import com.LinkedList.ListNode;

import java.util.HashSet;

public class FindIntersectionPointOfYLinkedList {
    public static void main(String[] args) {
    }

    // Approach 1 : Brute Force check for every element of one list
    // TC : O(M * N)
    public static ListNode bruteForce(ListNode head1, ListNode head2){

        while(head2 != null){
            ListNode temp = head1;
            while(temp != null){
                if(temp.equals(head2))
                    return temp;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    // Approach 2: Improved by Hashing
    // TC : O(M + N)
    // SC : O(N)

    public static ListNode byHashing(ListNode head1, ListNode head2){
        HashSet<ListNode> set = new HashSet<>();
        while(head2 != null){
            set.add(head2);
            head2 = head2.next;
        }
        while(head1 != null){
            if(set.contains(head1))
                return head1;
            head1 = head1.next;
        }
        return null;
    }

    // Approach 3 : optimized Using difference in length
    // TC :O(2max(length of list1,length of list2))+O(abs(length of list1-length of list2))+O(min(length of list1,length of list2))
    // SC : O(1)

    public static ListNode optimized(ListNode head1, ListNode head2){
        int diff = getDifferenceInLength(head1, head2);
        if(diff > 0){
            while(diff-- != 0)
                head1 = head1.next;
        }else{
            while(diff++ != 0)
                head2 = head2.next;
        }
        while(head1 != null){
            if(head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public static int getDifferenceInLength(ListNode head1, ListNode head2){
        int length1 = 0;
        int length2 = 0;
        while(head1 != null){
            length1++;
            head1 = head1.next;
        }
        while(head2 != null){
            length2++;
            head2 = head2.next;
        }
        return length1 - length2;

    }


}
