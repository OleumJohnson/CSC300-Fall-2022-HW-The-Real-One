package net.codejava;

public class LinkedList {
	  
    static Node head;

    static class Node {
  
        int data;
        Node next, prev;
  
        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
  
    Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    
    Node selectionSort(Node head)
    {
        Node a, b, c, d, r;
        a = b = head;
  
        while (b.next != null) {
            c = d = b.next;
            while (d != null) {
                if (b.data > d.data) {
                	if (b.next == d) {
                        if (b == head) {
                            b.next = d.next;
                            d.next = b;
                            r = b;
                            b = d;
                            d = r;
                            c = d;
                            head = b;
                            d = d.next;
                        }
  
                        else {
                            b.next = d.next;
                            d.next = b;
                            a.next = d;
  
                            r = b;
                            b = d;
                            d = r;
                            c = d;
                            d = d.next;
                        }
                    }
  
                    else {
                    	if (b == head) {
  
                            r = b.next;
                            b.next = d.next;
                            d.next = r;
                            c.next = b;
  
                            r = b;
                            b = d;
                            d = r;
                            c = d;
                            d = d.next;
                            head = b;
                        }

                        else {
                            r = b.next;
                            b.next = d.next;
                            d.next = r;
                            c.next = b;
                            a.next = d;
                            r = b;
                            b = d;
                            d = r;
                            c = d;
                            d = d.next;
                        }
                    }
                }
                else {
                    c = d;
                    d = d.next;
                }
            }
            a = b;
            b = b.next;
        }
        return head;
    }
  
    public static void main(String[] args) {
  
        LinkedList list = new LinkedList();
        list.head = new Node(42);
        list.head.next = new Node(4);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(21);
        list.head.next.next.next.next = new Node(14);
        list.head.next.next.next.next.next = new Node(5);
          
          
        Node node = null;
        node = list.selectionSort(head);
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        while (temp != null) {
            temp = temp.prev;
        }
  
    }
}