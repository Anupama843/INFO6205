package com.codeforalgo;
import java.util.*;

public class Assignment5 {
    /*
    1. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x <= arr[0]) {
            return getSubArray(arr, 0, k-1);
        } else if (x >= arr[arr.length-1]) {
            return getSubArray(arr, arr.length - k, arr.length - 1);
        } else {
            int index = Arrays.binarySearch(arr, x);
            if (index < 0)
                index = -index - 1;

            int left = Math.max(0, index - k);
            int right = Math.min(arr.length-1, index + k);
            while(right - left + 1 > k) {
                int absL = Math.abs(arr[left] - x);
                int absR = Math.abs(arr[right] - x);
                if (absL <= absR) {
                    right--;
                } else {
                    left++;
                }
            }
            return getSubArray(arr, left, right);
        }
    }

    private static List<Integer>getSubArray(int[] array, int start, int end) {
        List<Integer> list = new ArrayList();
        for (int i = start; i <= end; i++) {
            list.add(array[i]);
        }
        return list;
    }


    /*
    2. Find Intersection of 2 sorted arrays https://leetcode.com/problems/intersection-of-two-arrays/
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            int num = nums2[i];
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        int index = 0;
        int[] result = new int[set2.size()];
        for(int num: set2) {
            result[index++] = num;
        }

        return result;
    }

    /*
     3. Peak Index in a mountain https://leetcode.com/problems/peak-index-in-a-mountain-array/
     */

    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > arr[i+1]){
                return i;
            }
        }
        return 0;
    }

    /*
     4. Reorganize string https://leetcode.com/problems/reorganize-string/
     */
    public static String reorganizeString(String str) {
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> counts = new HashMap<>();
        for(char ch: str.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());
        while (maxHeap.size() > 1) {
            char first = maxHeap.remove();
            char second = maxHeap.remove();
            result.append(first);
            result.append(second);
            counts.put(first, counts.get(first) - 1);
            counts.put(second, counts.get(second) - 1);
            if (counts.get(first) > 0) {
                maxHeap.add(first);
            }
            if (counts.get(second) > 0) {
                maxHeap.add(second);
            }
        }
        if(!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (counts.get(last) > 1) {
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }

    /*
     5. Count number of 1's in sorted binary array https://www.geeksforgeeks.org/count-1s-sorted-binary-array/
     */
    public static int countOnes(int [] arr, int low, int high){
        if(high >= low) {
            int mid = (high + low)/2;
            if ( (mid == high || arr[mid+1] == 0) && (arr[mid] == 1)) {
                return mid+1;
            }
            if (arr[mid] == 1){
                return countOnes(arr, (mid + 1), high);
            }
            return countOnes(arr, low, (mid -1));
        }
        return 0;
    }
}
