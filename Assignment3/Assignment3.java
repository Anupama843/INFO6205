package com.codeforalgo;

public class Assignment3 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    1. Merge in between links (https://leetcode.com/problems/merge-in-between-linked-lists/)
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode temp = list1;
        int count = 0;
        ListNode aNode = null;
        ListNode bNode = null;
        while(temp != null) {
            if (count == a-1) {
                aNode = temp;
            } else if (count == b) {
                bNode = temp;
            }
            temp = temp.next;
            count++;
        }

        aNode.next = list2;
        temp = list2;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = bNode.next;
        return list1;
    }

    /*
    2. Swap Nodes in link list (https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
     */

    public ListNode swapNodes(ListNode head, int k) {

        if (head.next == null){
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int _k = count - (k - 1);

        if (k == _k) {
            return head;
        }

        ListNode first = null;
        ListNode second = null;

        temp = head;
        count = 1;
        while (temp != null) {
            if (count == k) {
                first = temp;
            } else  if (count == _k) {
                second = temp;
            }
            count++;
            temp = temp.next;
        }

        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;

        return head;
    }

    /*
    3. Remove link list element (https://leetcode.com/problems/remove-linked-list-elements/)
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode temp = new ListNode();
        temp.next = head;
        head = temp;
        while(temp.next != null) {
            if(temp.next.val == val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head.next;
    }

    /*
    4. Delete n nodes after m nodes (https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/)
     */
    static void linkdelete(ListNode head, int M, int N){
        ListNode current = head;
        while(current != null) {

            for(int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            ListNode temp = current.next;
            for(int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }

    }
}

