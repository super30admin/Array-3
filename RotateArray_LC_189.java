/*
Approach Brute Force - TLE
we shift one by one element from back to front
Time Complexity - O(N * K)
Space Complexity - O(1)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class RotateArray_LC_189 {
    public void rotate(int[] nums, int k) {
        //to speed up the rotation
        int n = nums.length;
        k %= n; //if k is 9 and array length is 9 we will rotate it just once
        for(int i = 0; i<k; i++) { //till k times
            int prev = nums[n-1]; //7
            for(int j = 0; j< n; j++) { // we will keep shifting elements
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
}
/*
Approach 2:
1) reverse the whole array
2) reverse 0-k-1 elements
3) reverse k till len-1 elements
Time Complexity - O(N)
Space Complexity - O(1)

*/
class Solution {
    public void rotate(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);

    }

    public void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
