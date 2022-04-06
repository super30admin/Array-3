import java.util.Arrays;
/*
Time complexity: O(N), N is the length of the nums array
Space Complexity: O(1), constant space
Run on leetcode: yes
Any difficulties: no

Approach:
1. There is a property of the right and left rotation of an array, in this question right rotation is required,
to rotate an array k-times rightward involves three steps,
    Step 1. Reverse the entire array
    Step 2. Divide array at K index and reverse from 0 to k-1
    Step 3. And reverse the array from k to nums.length-1

 */
public class RotateArray {
    public static void rotateArray(int[] nums, int k ){
       k = k%nums.length;

       reverse(nums, 0, nums.length-1);
       reverse(nums, 0, k-1);
       reverse(nums, k, nums.length-1);

    }

    public static void reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp  = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        rotateArray(nums, 2);
        System.out.println("Rotate array: "+ Arrays.toString(nums));
    }
}
