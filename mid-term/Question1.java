package LeetCode;
/*
Time & Space complexity
Time complexity: O(n), where n is the max length of n1 or n2
Space complexity: O(1)
 */

public class Question1 {
    public boolean areConverging(ListNode n1, ListNode n2){
        int lenA = getLength(n1);
        int lenB = getLength(n2);

        for(int i=0; i < lenA-lenB; i++) {
            n1 = n1.next;
        }

        for(int i = 0; i < lenB-lenA; i++) {
            n2 = n2.next;
        }

        while(n1 != null && n2 != null){
            if(n1.val == n2.val) {
                return true;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return false;
    }

    static int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        ListNode n2 = new ListNode(6);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(3);
        n2.next.next.next = new ListNode(4);
        n2.next.next.next.next = new ListNode(5);

        System.out.println(new Question1().areConverging(n1, n2));

        ListNode n21 = new ListNode(1);
        n21.next = new ListNode(2);
        n21.next.next = new ListNode(3);

        ListNode n22 = new ListNode(6);
        System.out.println(new Question1().areConverging(n21, n22));
    }

}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
