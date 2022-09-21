package com.LinkedListAndArrays;

import java.util.HashMap;

public class CloneALinkedListWithRandomAndNextPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node head2 = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, head2);
        Node temp = head.next;
        Node temp3 = head2;
        while (temp != null) {
            Node temp2 = new Node(temp.val);
            temp3.next = temp2;
            map.put(temp, temp2);
            temp = temp.next;
            temp3 = temp3.next;
        }
        temp = head;
        temp3 = head2;
        while (temp != null) {
            temp3.random = map.get(temp.random);
            temp = temp.next;
            temp3 = temp3.next;
        }
        return head2;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

