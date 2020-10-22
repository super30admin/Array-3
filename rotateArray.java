//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: yes

class Solution {
    public void rotate(int[] nums, int k) {
        //if k is greater than the length of the array
        k = k % nums.length;
        
        //reverse entire array
        reverse(nums,0,nums.length-1);
        
        //reverse first k elements
        reverse(nums,0,k-1);
        
        //reverse rest of the elements
        reverse(nums,k,nums.length-1);
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
