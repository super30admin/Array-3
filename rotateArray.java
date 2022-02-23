
// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k >= n){
            k=k%n;
        }

        //reverse the entire array
        reverse(nums, 0, n-1);

        //reverse the k-length elements
        reverse(nums, 0, k-1);

        //reverse the remaining elements
        reverse(nums, k, n-1);
    }

    //reverse
    public static void reverse(int[] nums, int start, int end){  // T.C - O(N), S.C - O(1)
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

