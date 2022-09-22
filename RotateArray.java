//Approach - 1: Swapping: Reverse All 0 to n-1, Then Reverse 0 to k-1, adn Reverse k to n-1
//Time Complexity : O(n)
//Space Complexity : 

class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        if(k>=n) k = k%n;
        //Reverse all numbers
        reverse(nums, 0, n-1);
        //Reverse from 0 to k-1
        reverse(nums, 0, k-1);
        //Reverse from k to n-1
        reverse(nums, k, n-1);
    }
    private void reverse(int [] nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
