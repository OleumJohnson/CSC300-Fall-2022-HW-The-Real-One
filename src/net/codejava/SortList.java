package net.codejava;

public class SortList {
	 
    class Node {
        int data;
        Node next;
 
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
 
    public Node head = null;
    public Node tail = null;
 
    public void addNode(int data)
    {
         Node newNode = new Node(data);
         if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display()
    {
        Node current = head;
 
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
 
        System.out.println();
    }
    
    //bubble sort
    public void sort()
    {
        Node curr = head, index = null;
 
        int temp;
 
        if (head == null) {
            return;
        }
        else {
            while (curr != null) {
                index = curr.next;
 
                while (index != null) {
                    if (curr.data > index.data) {
                        temp = curr.data;
                        curr.data = index.data;
                        index.data = temp;
                    }
 
                    index = index.next;
                }
                curr = curr.next;
            }
        }
    }
 
    public static void main(String[] args)
    {
        SortList list = new SortList();
        list.addNode(2);
        list.addNode(8);
        list.addNode(4);
        list.addNode(1);
 
        list.sort();
        list.display();
    }
}