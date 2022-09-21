package com.LinkedList;
/*
 *
 * @UtkarshAgarwal
 */


public class DeleteAGivenNodeWhenANodeIsGiven {
    public static void main(String[] args) {


    }
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
}
