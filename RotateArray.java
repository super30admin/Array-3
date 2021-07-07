// 189.
// brute force - store last element in temp variable, shift all elements to right by 1step, store the value in temp in 0th index - repeat k times - time - O(nk) with constant space

//time - O(n) with constant space
class Solution {
    public void rotate(int[] nums, int k) {
        //[1,2,3,4,5,6,7] with k = 3 is [5,6,7,1,2,3,4] which is obtained by
        // 1. reverse whole arr to get [7,6,5,4,3,2,1]
        // 2. reverse first k elements to get [5,6,7,4,3,2,1]
        // 3. reverse the last n - k elements to get [5,6,7,1,2,3,4]
        // if k > nums.length, k = k % n to optimize
        
        k = k % nums.length; //if k = 9 and length is 7 is same as k = 2 for length 7 nums[]
        //edge
        if(k == 0)
        {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return;
    }
    
    private void reverse(int[] nums, int low, int high) {
        while(low < high)
        {
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
        return;
    }
}
