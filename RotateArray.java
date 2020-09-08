//Did this code ran on leetcode: yes
//Approach : This approach is based on the fact that when we rotate the array k times, k elements from the back end of the array come 
to the front and the rest of the elements from the front shift backwards.
In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the 
rest n-k elements gives us the required result.
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
         
        if (nums.length <= 1 || k == 0) return;
         int n = nums.length;
        k = k % n;
        reverse(nums , 0 , n - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , n - 1);
    }
    private void reverse(int[] nums , int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}