package com.codeforalgo;
public class LinkedList {

    /*1. Swap Nodes in Pairs
    Given a linked list, swap every two adjacent nodes and return its head.*/

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            int temp = current.val;
            current.val = current.next.val;
            current.next.val = temp;

            current = current.next;
            if (current.next != null) {
                current = current.next;
            }
        }
        return head;
    }

    /*
    2. Delete Node in a Linked List
    Write a function to delete a node in a singly-linked list.
    You will not be given access to the head of the list,
    instead you will be given access to the node to be deleted directly.
    It is guaranteed that the node to be deleted is not a tail node in the list.
    */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*
    3. Odd Even Linked List
    Given a singly linked list, group all odd nodes together followed by the even nodes.
    Please note here we are talking about the node number and not the value in the nodes
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
    }

    /*
    4. Split Link list in parts
    Given a (singly) linked list with head node root
    write a function to split the linked list into k consecutive linked list "parts".
    */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head = root;
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }

        int length = count/k, reminder = count % k;
        ListNode[] result = new ListNode[k];
        head = root;
        for( int i = 0; i < k; i++){
            int l = length;
            if(reminder > 0) {
                l++;
                reminder--;
            }
            result[i] = head;

            ListNode current = head;
            while (l-- > 0 && head != null) {
                current = head;
                head = head.next;
                if (l == 0) {
                    current.next = null;
                }
            }
        }
        return result;
    }

    /*
    5. Insert in Circular link list
    */
    public ListNode sortedInsert(ListNode head, int newVal) {
        ListNode newNode = new ListNode(newVal);
        ListNode temp = head;
        if (temp == null) {
            newNode.next = newNode;
            head = newNode;
        } else if (temp.val > newNode.val) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            while (temp.next != head && temp.next.val > newNode.val) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;
    }
}