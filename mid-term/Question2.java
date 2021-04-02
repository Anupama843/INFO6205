

import java.util.Stack;

/*
Time & Space complexity
Time complexity: O(n), where n is the size of tree
Space complexity: O(1)
 */
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}


public class Question2 {

    private static void printLeaves(TreeNode node)
    {
        if (node == null) {
            return;
        }

        printLeaves(node.right);

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        printLeaves(node.left);
    }

    private static void printLeftSide(TreeNode node)
    {
        if (node == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        if (node.left != null) {
            stack.push(node.data);
            printLeftSide(node.left);
        }  else if (node.right != null) {
            stack.push(node.data);
            printLeftSide(node.right);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void printRightSide(TreeNode node)
    {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            System.out.print(node.data + " ");
            printRightSide(node.right);
        }
        else if (node.left != null) {
            System.out.print(node.data + " ");
            printRightSide(node.left);
        }
    }

    static void printPerimeter(TreeNode node)  {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printRightSide(node.right);
        printLeaves(node.right);
        printLeaves(node.left);
        printLeftSide(node.left);
    }
//1,3,7,14,13,11,10,9,8,4,2
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(13);

        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);

        printPerimeter(root);
    }
}
