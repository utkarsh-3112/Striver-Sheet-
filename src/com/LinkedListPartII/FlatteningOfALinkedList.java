package com.LinkedListPartII;
/*
 *
 * @UtkarshAgarwal
 */


import com.LinkedList.ListNode;

class FlatteningOfALinkedList{
    static class Fnode{
        int val;
        Fnode next;
        Fnode bottom;
    }

    // Approach : Merge n no. of list to make one list
    // TC : O(N)
    // SC : O(1)

    public static Fnode flatten(Fnode head){

        if(head == null || head.next == null)
            return head;

        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }

    private static Fnode merge(Fnode a, Fnode b) {
        Fnode temp = new Fnode();
        Fnode res = temp;
        while(a != null && b != null){
            if(a.val >= b.val){
                temp.bottom = b;
                b = b.bottom;
            }else{
                temp.bottom = a;
                a = a.bottom;
            }
            temp = temp.bottom;
        }
        if(a != null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
    }
}



