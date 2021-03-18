package Assignment6;

import java.util.*;



public class Assignment6 {
    /*
    1. Subtree of Another Tree (https://leetcode.com/problems/subtree-of-another-tree/)
    */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode node = findNode(s, t.val);
        if (node == null) {
            return false;
        }
        return isSame(node, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private TreeNode findNode(TreeNode s, int value) {
        if (s == null) {
            return null;
        }
        if (s.val == value) {
            return s;
        }
        TreeNode left = findNode(s.left, value);
        if (left != null) {
            return left;
        }
        return findNode(s.right, value);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /*
    2. Asteroid Collision (https://leetcode.com/problems/asteroid-collision/)
    */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int value : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && value < 0 && stack.peek() > 0) {
                push = false;
                if (stack.peek() == Math.abs(value)) {
                    stack.pop();
                } else if (stack.peek() < Math.abs(value)) {
                    stack.pop();
                    push = true;
                    continue;
                }
                break;
            }
            if (push) {
                stack.push(value);
            }
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index--;
        }
        return result;
    }
    /*
    3.3Sum (https://leetcode.com/problems/3sum/)
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[start]);
                    subResult.add(nums[end]);
                    result.add(subResult);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    /*
    4. Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", n, n);
        return ans;
    }

    public void backtrack(List<String> ans, String temp, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(temp);
        } else {
            if (open > 0) {
                backtrack(ans, temp + "(", open - 1, close);
            }

            if (close > open) {
                backtrack(ans, temp + ")", open, close - 1);
            }
        }
    }

    /*
    5. Reverse Nodes in k-Group (https://leetcode.com/problems/reverse-nodes-in-k-group/)
     */


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        int result = 0;

        while (current != null && result < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            result++;
        }
        if (result < k) {
            current = previous;
            previous = null;
            next = null;
            while (result != 0) {
                result--;
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return previous;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }

    }
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

    }
}



