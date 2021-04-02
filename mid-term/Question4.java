package LeetCode;

/*
Time & Space complexity
Time complexity: O(log(n)), where n is the length of array
Space complexity: O(1)
 */

public class Question4 {
    static int binarySearch( int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }


    static int getIndex(int[] nums, int x) {
        int low = 0;
        int hight = nums.length;
        return binarySearch(nums, x, low, hight);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 4, 4, 7, 7, 7, 7, 8, 8};
        System.out.println(getIndex(arr, 7));
    }
}
