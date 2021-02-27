package com.codeforalgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Assignment4 {
    private static void swap(int[] array, int i, int j) {
        if (array == null || array.length < 2 || i < 0 || j < 0 || i >= array.length || j >= array.length) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int wall = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                wall++;
                swap(array, i, wall);
            }
        }
        wall++;
        swap(array, high, wall);
        return wall;
    }

    /*
    1. Find intersection of 2 unsorted arrays https://leetcode.com/problems/intersection-of-two-arrays/solution/
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int index = 0;
        int[] result = new int[set2.size()];
        for (int num : set2) {
            result[index++] = num;
        }
        return result;
    }

    /*
    2. Find nth Smallest of an unsorted array.
    https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/ (Links to an external site.)
     */
    public static void findNthSmallest(int[] array, int n) {
        if (array == null || array.length == 0 || n < 0 || n > array.length) {
            return;
        }
        findNthSmallest(array, n, 0, array.length - 1);
    }

    private static void findNthSmallest(int[] array, int n, int low, int high) {
        if (low <= high) {
            int position = partition(array, low, high);
            if (position == (n - 1)) {
                System.out.println(array[position]);
                return;
            }
            findNthSmallest(array, n, low, position - 1);
            findNthSmallest(array, n, position + 1, high);
        }
    }

    /*
    3. Sort colors https://leetcode.com/problems/sort-colors/
     */
    public static void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length-1);
    }

    private static void quicksort(int [] array, int low, int high){
        if(low < high){
            int position = partition(array, low, high);
            quicksort(array, low, position - 1);
            quicksort(array, position +1, high);
        }
    }

    /*
    4. Pancake sort https://leetcode.com/problems/pancake-sorting/
     */
    public static List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> result = new ArrayList();

        for(int i = arr.length; i > 0; i--) {
            int index = findIndex(arr, i);
            if (index == i - 1)
                continue;
            if (index != 0) {
                result.add(index+1);
                flip(arr, index);
            }
            result.add(i);
            flip(arr, i-1);
        }
        return result;
    }

    private static int findIndex(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static void flip(int[] arr, int index) {
        if (arr.length <= index) {
            return;
        }
        int start = 0;
        int end = index;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
