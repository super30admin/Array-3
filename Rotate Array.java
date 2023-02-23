// Time Complexity = O(n)
// Space Complexity = O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if(k>l) 
            k = k%l;
        
        reverse(nums, l-k, l-1);
        reverse(nums, 0, l-k-1);
        reverse(nums, 0, l-1);
        
    }
    
    private void reverse(int [] nums, int start, int end){
        int temp;
        while(start <= end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap (int [] nums, int start, int end){
        int temp;
        temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}