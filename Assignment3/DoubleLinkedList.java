package com.codeforalgo;

/*
    5. Design and implement a Double Link list
       Create a class for Node which has next and prev pointers
       Create class for double link list  and add functions for Add to tail, Add to head, size
       print list functions to the class.
     */


public class DoubleLinkedList {

    public static class Node {
        int value;
        Node next;
        Node previous;
        Node(int value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public Node head;

    public DoubleLinkedList() {
        head = null;
    }

    public void addHead(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    public void addTail(int value){
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.previous = temp;

    }
    public int size(){
        if(head == null)
            return  0;

        int count = 1;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }

    public void printList(){
        if(head == null)
            return;

        Node temp = head;
        System.out.print("null<-");
        while(temp.next != null){
            System.out.print(temp.value + "<->");
            temp = temp.next;
        }
        System.out.println(temp.value + "->" + "null");
    }

    public static void main(String[] arg) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.head = new DoubleLinkedList.Node(1);

        for(int i = 2; i<12; i++) {
            dll.addTail(i);
        }

        dll.addTail(15);
        dll.addTail(19);
        dll.addHead(99);
        dll.printList();
        System.out.println(dll.size());

        DoubleLinkedList dll2 = new DoubleLinkedList();
        dll2.addTail(1);
        System.out.println(dll2.size());
        dll2.printList();
    }
}
