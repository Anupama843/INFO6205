
/*
Time & Space complexity
Time complexity: O(n), where n is the length of array
Space complexity: O(1)
 */

public class Question3 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int min = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            min = (nums[i] == 0) ? 0 : min + 1;
            max = (min > max) ? min : max;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,1,0,0,0,1,1,1,1};
        int[] nums2 = {1,1,1,0,1,1,0,0,0,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

}
